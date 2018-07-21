package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.Account;
import domain.Auto;
import domain.Configurazione;
import domain.ConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;
import exception.ServerError;

public class ConfigurazioneAutoDAO {
	
	protected static Map<Integer, ConfigurazioneAuto> restoredObjects= new java.util.HashMap<Integer, ConfigurazioneAuto>();

	public static void createConfigurazioneAuto(ConfigurazioneAuto confauto, Auto auto, Account account) throws ServerError{
		
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("INSERT INTO CONFIGURAZIONIAUTO(AutoID, ConfigurazioneID, AccountID) VALUES (?,?,?)")){
			pstat.setInt(1, auto.getId());
			pstat.setInt(2, confauto.getConfigurazione().getId());
			pstat.setInt(3, account.getId());
			pstat.executeUpdate();
			
			confauto.setId(auto.getId());
			restoredObjects.put(confauto.getId(), confauto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		}		
	}
	
	public static boolean cerca(Integer id) throws ServerError{
		if(id==null)
			return false;
		if (restoredObjects.containsKey(id))
			return true;
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT * FROM CONFIGURAZIONIAUTO WHERE AutoID=?")){
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		}
		return false;
	}
	
	public static void update(ConfigurazioneAuto confauto, Account account) throws ConfigurazioneAutoInesistente, ServerError{
		if(confauto.getId() == null)
			throw new ConfigurazioneAutoInesistente();
		Connection c=DBManager.getConnection();
		PreparedStatement pstat;
		try {
			pstat = c.prepareStatement("UPDATE CONFIGURAZIONIAUTO SET ConfigurazioneID=?, AccountID=? WHERE AutoID=?");
			pstat.setInt(1, confauto.getConfigurazione().getId());
			pstat.setInt(2, account.getId());
			pstat.setInt(3, confauto.getId());
			pstat.executeUpdate();
			pstat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		}

	}
	
	public static List<ConfigurazioneAuto> readList(Account ac) throws ServerError{
		List<ConfigurazioneAuto> lista = new ArrayList<ConfigurazioneAuto>();
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT AutoID, ConfigurazioneID FROM CONFIGURAZIONIAUTO WHERE AccountID=?")){
			pstat.setInt(1, ac.getId());
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				Configurazione config = ac.getConfigurazione(rs.getInt(2));
				ConfigurazioneAuto confat = new ConfigurazioneAuto(config, rs.getInt(1));
				if(!restoredObjects.containsKey(confat.getId()))
					restoredObjects.put(confat.getId(), confat);
				lista.add(confat);
				ac.getAuto(rs.getInt(1)).setConfigurazioneAuto(confat);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		}

		return lista;
	}
	
}
