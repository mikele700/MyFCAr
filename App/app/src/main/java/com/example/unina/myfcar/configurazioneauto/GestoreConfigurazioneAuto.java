package com.example.unina.myfcar.configurazioneauto;

import com.example.unina.myfcar.iclient.IGestoreConfigurazioneAuto;

import business.domain.Account;
import business.domain.Auto;
import business.domain.Configurazione;
import business.domain.ConfigurazioneAuto;
import business.server.iserver.IServerGestoreConfigurazioneAuto;
import exception.ConfigurazioneAutoInesistente;
import exception.ServerError;

/**
 * Created by Davide on 15/07/2018.
 */

public class GestoreConfigurazioneAuto implements IGestoreConfigurazioneAuto{

    private static GestoreConfigurazioneAuto instance = null;

    private GestoreConfigurazioneAuto(){}

    public static GestoreConfigurazioneAuto getInstance(){
        if(instance == null)
            instance = new GestoreConfigurazioneAuto();
        return instance;
    }

    @Override
    public String associaAuto(Account account, Auto auto, Configurazione configurazione,IServerGestoreConfigurazioneAuto server) {
        // TODO Auto-generated method stub
        ConfigurazioneAuto ca;
        String s = null;
        try {
            ca = server.associaAuto(account, auto, configurazione);
            if(ca!=null){
                s = new String("Operazione riuscita!");
                auto.setConfigurazioneAuto(ca);
                ConfigurazioneAuto old = account.getConfigurazioneAuto(auto);
                if(old!=null)
                    account.rimuoviConfigurazioneAuto(old);
                account.aggiungiConfigurazioneAuto(ca);
            }
        } catch (ServerError | ConfigurazioneAutoInesistente e) {
            // TODO Auto-generated catch block
            s = e.getMessage();
        }
        return s;
    }
}
