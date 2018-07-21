package business.client.configurazioneauto;

import business.client.iclient.IGestoreConfigurazioneAuto;
import business.server.iserver.IServerGestoreConfigurazioneAuto;
import domain.Account;
import domain.Auto;
import domain.Configurazione;
import domain.ConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;
import exception.ServerError;

public class GestoreConfigurazioneAuto implements IGestoreConfigurazioneAuto {
	
	private static GestoreConfigurazioneAuto instance = null;
	
	private GestoreConfigurazioneAuto(){}
	
	public static GestoreConfigurazioneAuto getInstance(){
		if(instance == null)
			instance = new GestoreConfigurazioneAuto();
		return instance;
	}

	@Override
	public void associaAuto(Account account, Auto auto, Configurazione configurazione,IServerGestoreConfigurazioneAuto server) {
		// TODO Auto-generated method stub
		ConfigurazioneAuto ca;
		try {
			ca = server.associaAuto(account, auto, configurazione);
			if(ca!=null){
				auto.setConfigurazioneAuto(ca);
				ConfigurazioneAuto old = account.getConfigurazioneAuto(auto);
				if(old!=null)
					account.rimuoviConfigurazioneAuto(old);
				account.aggiungiConfigurazioneAuto(ca);
				ca.stampaConfigurazioneAuto();
			}
		} catch (ServerError | ConfigurazioneAutoInesistente e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
