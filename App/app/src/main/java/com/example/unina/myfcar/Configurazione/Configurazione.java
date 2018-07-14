package com.example.unina.myfcar.Configurazione;

import java.util.List;
import java.util.Iterator;

/**
 * Created by Davide on 13/07/2018.
 */

public class Configurazione {
    private Integer id;
    private List<Setting> setting;

    public Configurazione(Integer id, List<Setting> s){
        this.id = id;
        setting = s;
    }

    public Integer getId() {
        return id;
    }

    public List<Setting> getSetting() {
        return setting;
    }

    public void stampaSetting(){
        for (Iterator<Setting> iterator = setting.iterator(); iterator.hasNext();) {
            Setting s = iterator.next();
            if(s instanceof SettingOptional)
                System.out.println("Setting ID "+s.getId()+" Nome "+((SettingOptional)s).getNome()+" Valore "+s.getValore());
            else
                System.out.println("Setting ID "+s.getId()+" Nome "+((SettingSerie)s).getNome()+" Valore "+s.getValore());
        }
    }
}
