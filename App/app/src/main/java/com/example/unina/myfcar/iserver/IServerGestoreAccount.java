package com.example.unina.myfcar.iserver;
import com.example.unina.myfcar.account.*;

/**
 * Created by Davide on 13/07/2018.
 */

public interface IServerGestoreAccount {

    public Account login(String email, String password);
    public void registra(String email, String password);
    public boolean verificaEmail(String email);
}
