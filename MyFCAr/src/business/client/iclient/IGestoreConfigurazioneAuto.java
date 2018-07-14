package business.client.iclient;

import business.domain.*;
import business.server.iserver.IServerGestoreConfigurazioneAuto;

public interface IGestoreConfigurazioneAuto {

	public void associaAuto(Account account, Auto auto, Configurazione configurazione, IServerGestoreConfigurazioneAuto server);
}
