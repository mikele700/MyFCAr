package business.server.configurazioneauto;

import business.server.iserver.IServerGestoreConfigurazioneAuto;
import data.ConfigurazioneAutoDAO;
import domain.Account;
import domain.Auto;
import domain.Configurazione;
import domain.ConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;
import exception.ServerError;

public class ServerGestoreConfigurazioneAuto implements IServerGestoreConfigurazioneAuto {
	
	public ConfigurazioneAuto associaAuto(Account account, Auto auto, Configurazione config) throws ServerError, ConfigurazioneAutoInesistente{
		ConfigurazioneAuto confauto = new ConfigurazioneAuto(config);
		if(ConfigurazioneAutoDAO.cerca(auto.getId())){
			confauto.setId(auto.getId());
			ConfigurazioneAutoDAO.update(confauto, account);
		}
		else{
			ConfigurazioneAutoDAO.createConfigurazioneAuto(confauto, auto, account);
			confauto.setId(auto.getId());
		}
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
