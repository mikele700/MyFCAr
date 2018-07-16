package com.example.unina.myfcar.iclient;

import business.domain.Account;
import business.domain.Auto;
import business.domain.Configurazione;
import business.server.iserver.IServerGestoreConfigurazioneAuto;

/**
 * Created by Davide on 13/07/2018.
 */

public interface IGestoreConfigurazioneAuto {

    public String associaAuto(Account account, Auto auto, Configurazione configurazione, IServerGestoreConfigurazioneAuto server);
}
