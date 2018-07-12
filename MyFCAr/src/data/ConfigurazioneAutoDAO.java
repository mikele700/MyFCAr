package data;

import java.sql.*;
import java.util.Map;

import business.server.account.Account;
import business.server.auto.Auto;
import business.server.configurazioneauto.ConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;

public class ConfigurazioneAutoDAO {
	
	protected static Map<Integer, ConfigurazioneAuto> restoredObjects= new java.util.HashMap<Integer, ConfigurazioneAuto>();

	public static void createConfigurazioneAuto(ConfigurazioneAuto confauto, Auto auto, Account account){
		
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("INSERT INTO CONFIGURAZIONIAUTO(AutoID, ConfigurazioneID, AccountID) VALUES (?,?,?)")){
			pstat.setInt(1, auto.getId());
			pstat.setInt(2, confauto.getConfigurazione().getId());
			pstat.setInt(3, account.getId());
			pstat.executeUpdate();
			pstat.close();
			
			confauto.setId(auto.getId());
			restoredObjects.put(confauto.getId(), confauto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static boolean cerca(Integer id){
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
		}
		return false;
	}
	
	public static void update(ConfigurazioneAuto confauto, Account account) throws ConfigurazioneAutoInesistente{
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
		}

	}
	
}
