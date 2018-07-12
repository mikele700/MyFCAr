package business.server.iserver;

import business.server.account.Account;
import business.server.auto.Auto;
import business.server.configurazione.Configurazione;
import business.server.configurazioneauto.ConfigurazioneAuto;

public interface IServerGestoreConfigurazioneAuto {
	public ConfigurazioneAuto associaAuto(Account account, Auto auto, Configurazione config);

}
