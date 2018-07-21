package business.client.iclient;

import business.server.iserver.IServerGestoreConfigurazioneAuto;
import domain.Account;
import domain.Auto;
import domain.Configurazione;

public interface IGestoreConfigurazioneAuto {

	public void associaAuto(Account account, Auto auto, Configurazione configurazione, IServerGestoreConfigurazioneAuto server);
}
