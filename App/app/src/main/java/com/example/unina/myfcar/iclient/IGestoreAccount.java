package com.example.unina.myfcar.iclient;

import java.util.List;

import business.server.iserver.IServerGestoreAccount;
import domain.Account;
import domain.Auto;
import domain.Configurazione;
import domain.ConfigurazioneAuto;

/**
 * Created by Davide on 13/07/2018.
 */

public interface IGestoreAccount {

    public String login(String email, String password, IServerGestoreAccount sga);
    public void logout();
    public void registra(String email, String password, IServerGestoreAccount sga);
    public boolean verificaEmail(String email, IServerGestoreAccount sga);
    public Account getAccount();
    public List<Configurazione> getConfigurazioneAccount();
    public List<Auto> getAutoAccount();
    public List<ConfigurazioneAuto> getConfigurazioneAutoAccount();
    public Auto cercaAutoAccount(Integer idAuto);
}
