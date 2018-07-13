package business.server.configurazioneauto;

import java.sql.SQLException;

import business.server.account.Account;
import business.server.auto.Auto;
import business.server.configurazione.Configurazione;
import business.server.iserver.IServerGestoreConfigurazioneAuto;
import data.ConfigurazioneAutoDAO;
import data.DBManager;
import exception.ConfigurazioneAutoInesistente;

public class ServerGestoreConfigurazioneAuto implements IServerGestoreConfigurazioneAuto {
	
	public ConfigurazioneAuto associaAuto(Account account, Auto auto, Configurazione config){
		ConfigurazioneAuto confauto = new ConfigurazioneAuto(config);
		if(ConfigurazioneAutoDAO.cerca(auto.getId())){
			confauto.setId(auto.getId());
			try {
				ConfigurazioneAutoDAO.update(confauto, account);
			} catch (ConfigurazioneAutoInesistente e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else
			ConfigurazioneAutoDAO.createConfigurazioneAuto(confauto, auto, account);
		return confauto;
	}
	
	/* TEST
	 * public static void main(String[] args){
		Account acc = new Account(2);
		Auto at = new Auto("a", "b", "c", 1);
		Configurazione cf = new Configurazione(3);
		ServerGestoreConfigurazioneAuto sca = new ServerGestoreConfigurazioneAuto();
		ConfigurazioneAuto ca = sca.associaAuto(acc, at, cf);
		System.out.println("ID"+ca.getId());
		System.out.println("ID Config"+ca.getConfigurazione().getId());
		try {
			DBManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
