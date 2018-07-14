package business.server.iserver;

import business.domain.Account;
import business.domain.Auto;
import business.domain.Configurazione;
import business.domain.ConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;
import exception.ServerError;

public interface IServerGestoreConfigurazioneAuto {
	public ConfigurazioneAuto associaAuto(Account account, Auto auto, Configurazione config) throws ServerError, ConfigurazioneAutoInesistente;

}
