package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import business.domain.Account;
import business.domain.Configurazione;
import exception.ServerError;

public class ConfigurazioneDAO {
	
	protected static Map<Integer, Configurazione> restoredObjects= new java.util.HashMap<Integer, Configurazione>();

	public static List<Configurazione> readList(Account ac) throws ServerError{
		List<Configurazione> lista = new ArrayList<Configurazione>();
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT ID FROM CONFIGURAZIONI WHERE AccountID=?")){
			pstat.setInt(1, ac.getId());
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				Configurazione conf = new Configurazione(rs.getInt("ID"), SettingDAO.readListConfigurazione(rs.getInt("ID")));
				if(!restoredObjects.containsKey(conf.getId()))
					restoredObjects.put(conf.getId(), conf);
				lista.add(conf);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		}

		return lista;
	}

}
