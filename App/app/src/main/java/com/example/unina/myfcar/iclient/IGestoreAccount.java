package com.example.unina.myfcar.iclient;

import business.domain.Account;
import business.server.iserver.IServerGestoreAccount;

/**
 * Created by Davide on 13/07/2018.
 */

public interface IGestoreAccount {

    public void login(String email, String password, IServerGestoreAccount sga);
    public void logout(Account account);
    public void registra(String email, String password, IServerGestoreAccount sga);
    public boolean verificaEmail(String email, IServerGestoreAccount sga);
    public Account getAccount();
}
