package com.example.unina.myfcar.account;

import com.example.unina.myfcar.iserver.IServerGestoreAccount;

/**
 * Created by Davide on 13/07/2018.
 */

public class ProxyGestoreAccount implements IServerGestoreAccount{

    private static ProxyGestoreAccount instance = null;
    private ProxyGestoreAccount(){}

    public static ProxyGestoreAccount getInstance(){

        if(instance==null){
            instance = new ProxyGestoreAccount();
        }
        return instance;
    }


    @Override
    public void login(String email, String password) {

    }

    @Override
    public void registra(String email, String password) {

    }

    @Override
    public boolean verificaEmail(String email) {
        return false;
    }
}
