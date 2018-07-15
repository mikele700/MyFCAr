package com.example.unina.myfcar.iclient;

import java.util.List;

import business.domain.Account;
import business.domain.Auto;
import business.domain.Configurazione;
import business.domain.ConfigurazioneAuto;
import business.server.iserver.IServerGestoreAccount;

/**
 * Created by Davide on 13/07/2018.
 */

public interface IGestoreAccount {

    public String login(String email, String password, IServerGestoreAccount sga);
    public void logout(Account account);
    public void registra(String email, String password, IServerGestoreAccount sga);
    public boolean verificaEmail(String email, IServerGestoreAccount sga);
    public Account getAccount();
    public List<Configurazione> getConfigurazioneAccount();
    public List<Auto> getAutoAccount();
    public List<ConfigurazioneAuto> getConfigurazioneAuto();
}
