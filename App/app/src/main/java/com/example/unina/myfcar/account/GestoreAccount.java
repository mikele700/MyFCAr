package com.example.unina.myfcar.account;

import com.example.unina.myfcar.iclient.IGestoreAccount;

import java.util.List;

import business.server.iserver.IServerGestoreAccount;
import domain.Account;
import domain.Auto;
import domain.Configurazione;
import domain.ConfigurazioneAuto;
import exception.AccountInesistente;
import exception.ServerError;


/**
 * Created by Davide on 13/07/2018.
 */

public class GestoreAccount implements IGestoreAccount{

    private static GestoreAccount instance = null;
    private Account logged;


    private GestoreAccount(){
    }

    public static GestoreAccount getInstance(){

        if(instance==null){
            instance = new GestoreAccount();
        }
        return instance;
    }


    @Override
    public String login(String email, String password, IServerGestoreAccount iserver) {
        // TODO Auto-generated method stub
        String s=null;
        try {
            logged = iserver.login(email, password);
            if(logged != null){
                s = new String("ok");
            }
        } catch (AccountInesistente | ServerError e ) {
            // TODO Auto-generated catch block
            s = e.getMessage();
        } catch (RuntimeException e){
            s = "Email e/o password errati!";
        }
        return s;
    }

    @Override
    public void logout() {
        logged = null;
    }

    @Override
    public void registra(String email, String password, IServerGestoreAccount iserver) {
        iserver.registra(email,password);
    }

    @Override
    public boolean verificaEmail(String email, IServerGestoreAccount iserver) {
        return iserver.verificaEmail(email);
    }

    @Override
    public Account getAccount() {
        // TODO Auto-generated method stub
        return logged;
    }

    @Override
    public List<Configurazione> getConfigurazioneAccount() {
        // TODO Auto-generated method stub
        return logged.getAllConfigurazione();
    }

    @Override
    public List<Auto> getAutoAccount() {
        // TODO Auto-generated method stub
        return logged.getAllAuto();
    }

    @Override
    public List<ConfigurazioneAuto> getConfigurazioneAutoAccount() {
        return logged.getAllConfigurazioneAuto();
    }

    @Override
    public Auto cercaAutoAccount(Integer idAuto){
        return logged.getAuto(idAuto);
    }
}
