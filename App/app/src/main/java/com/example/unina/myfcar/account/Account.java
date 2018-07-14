package com.example.unina.myfcar.account;

import com.example.unina.myfcar.Configurazione.Configurazione;
import com.example.unina.myfcar.auto.Auto;
import com.example.unina.myfcar.configurazioneauto.ConfigurazioneAuto;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Davide on 13/07/2018.
 */

public class Account {

    private Integer id;
    private String email;
    private String password;
    private List<Auto> ParcoAuto;
    private List<Configurazione> ListaConfigurazioni;
    private List<ConfigurazioneAuto> ListaConfigurazioniAuto;

    public Account(Integer id, String e, String pw){
        this.id =id;
        email = e;
        password = pw;
        ParcoAuto = new ArrayList<Auto>();
        ListaConfigurazioni = new ArrayList<Configurazione>();
        ListaConfigurazioniAuto = new ArrayList<ConfigurazioneAuto>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void aggiungiAuto(Auto a){
        ParcoAuto.add(a);
    }

    public void aggiungiConfigurazione(Configurazione c){
        ListaConfigurazioni.add(c);
    }

    public void aggiungiConfigurazioneAuto(ConfigurazioneAuto ca){
        ListaConfigurazioniAuto.add(ca);
    }

    public List<Configurazione> getAllConfigurazione(){
        return new ArrayList<Configurazione>(ListaConfigurazioni);

    }

    public List<Auto> getAllAuto(){
        return new ArrayList<Auto>(ParcoAuto);

    }

    public List<ConfigurazioneAuto> getAllConfigurazioneAuto(){
        return new ArrayList<ConfigurazioneAuto>(ListaConfigurazioniAuto);

    }

    public Auto getAuto(Integer id){
        for (Iterator<Auto> iterator = ParcoAuto.iterator(); iterator.hasNext();) {
            Auto at = iterator.next();
            if(at.getId()==id)
                return at;
        }
        return null;
    }

    public Configurazione getConfigurazione(Integer id){
        for (Iterator<Configurazione> iterator = ListaConfigurazioni.iterator(); iterator.hasNext();) {
            Configurazione c = iterator.next();
            if(c.getId()==id)
                return c;
        }
        return null;
    }

    public void setParcoAuto(List<Auto> parcoAuto) {
        ParcoAuto = parcoAuto;
    }

    public void setListaConfigurazioni(List<Configurazione> listaConfigurazioni) {
        ListaConfigurazioni = listaConfigurazioni;
    }

    public void setListaConfigurazioniAuto(List<ConfigurazioneAuto> listaConfigurazioniAuto) {
        ListaConfigurazioniAuto = listaConfigurazioniAuto;
    }
}
