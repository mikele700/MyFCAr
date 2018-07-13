package com.example.unina.myfcar.account;

import com.example.unina.myfcar.iclient.IGestoreAccount;
import com.example.unina.myfcar.iserver.IServerGestoreAccount;

/**
 * Created by Davide on 13/07/2018.
 */

public class GestoreAccount implements IGestoreAccount{

    private static GestoreAccount instance = null;
    private Account account;

    private GestoreAccount(){
    }

    public static GestoreAccount getInstance(){

        if(instance==null){
            instance = new GestoreAccount();
        }
        return instance;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    @Override
    public void login(String email, String password, IServerGestoreAccount sga) {
        sga.login(email,password);
    }

    @Override
    public void logout(Account account) {

    }

    @Override
    public void registra(String email, String password, IServerGestoreAccount sga) {
        sga.registra(email,password);
    }

    @Override
    public boolean verificaEmail(String email, IServerGestoreAccount sga) {
        return sga.verificaEmail(email);
    }

    @Override
    public Account getAccount() {
        return null;
    }
}
