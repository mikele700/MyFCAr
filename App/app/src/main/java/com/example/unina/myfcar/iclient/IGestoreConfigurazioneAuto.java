package com.example.unina.myfcar.iclient;

import business.server.iserver.IServerGestoreConfigurazioneAuto;
import domain.Account;
import domain.Auto;
import domain.Configurazione;

/**
 * Created by Davide on 13/07/2018.
 */

public interface IGestoreConfigurazioneAuto {

    public String associaAuto(Account account, Auto auto, Configurazione configurazione, IServerGestoreConfigurazioneAuto server);
}
