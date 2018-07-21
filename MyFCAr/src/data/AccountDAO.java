package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import domain.Account;
import exception.AccountInesistente;
import exception.ServerError;

public class AccountDAO {
	protected static Map<Integer, Account> restoredObjects= new java.util.HashMap<Integer, Account>();
	
	public static Account read(String e, String pw) throws AccountInesistente, ServerError{
		Account ac = null;
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT ID FROM ACCOUNT WHERE Email=? AND Password=?")){
			pstat.setString(1, e);
			pstat.setString(2, pw);
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				ac = new Account(rs.getInt("ID"), e, pw);
				restoredObjects.put(ac.getId(), ac);
				/*
				pstat = c.prepareStatement("SELECT ID FROM CONFIGURAZIONI WHERE AccountID=?");
				pstat.setInt(1, ac.getId());
				rs = pstat.executeQuery();
				while(rs.next()){
					ac.aggiungiConfigurazione(new Configurazione(rs.getInt("ID")));
				}*/
				ac.setListaConfigurazioni(ConfigurazioneDAO.readList(ac));
				
				/*
				pstat = c.prepareStatement("SELECT ID, VIN, Targa, Modello FROM AUTO, ACCOUNTAUTO WHERE AccountID=? AND AutoID=ID");
				pstat.setInt(1, ac.getId());
				rs = pstat.executeQuery();
				while(rs.next()){
					ac.aggiungiAuto(new Auto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}*/
				ac.setParcoAuto(AutoDAO.readList(ac));
				
				/*
				pstat = c.prepareStatement("SELECT AutoID, ConfigurazioneID FROM CONFIGURAZIONIAUTO WHERE AccountID=?");
				pstat.setInt(1, ac.getId());
				rs = pstat.executeQuery();
				while(rs.next()){
					Configurazione config = ac.getConfigurazione(rs.getInt(2));
					ConfigurazioneAuto confat = new ConfigurazioneAuto(config, rs.getInt(1));
					ac.getAuto(rs.getInt(1)).setConfigurazioneAuto(confat);
				}*/
				ac.setListaConfigurazioniAuto(ConfigurazioneAutoDAO.readList(ac));
				
				//pstat.close();
			}
			else{
				//pstat.close();
				throw new AccountInesistente();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		}

		return ac;
	}

}
