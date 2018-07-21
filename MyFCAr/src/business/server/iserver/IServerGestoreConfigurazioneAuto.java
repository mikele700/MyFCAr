package business.server.iserver;

import domain.Account;
import domain.Auto;
import domain.Configurazione;
import domain.ConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;
import exception.ServerError;

public interface IServerGestoreConfigurazioneAuto {
	public ConfigurazioneAuto associaAuto(Account account, Auto auto, Configurazione config) throws ServerError, ConfigurazioneAutoInesistente;

}
