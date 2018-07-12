package business.server.configurazioneauto;

import business.server.account.Account;
import business.server.auto.Auto;
import business.server.configurazione.Configurazione;
import business.server.iserver.IServerGestoreConfigurazioneAuto;
import data.ConfigurazioneAutoDAO;
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
		ConfigurazioneAutoDAO.createConfigurazioneAuto(confauto, auto, account);
		return confauto;
	}
	
}
