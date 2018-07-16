package com.example.unina.myfcar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.unina.myfcar.R;
import com.example.unina.myfcar.account.GestoreAccount;
import com.example.unina.myfcar.iclient.IGestoreAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import business.domain.Configurazione;
import business.domain.Setting;
import business.domain.SettingOptional;
import business.domain.SettingSerie;

public class ListaConfigurazioniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_configurazioni);

        ImageButton button = (ImageButton) findViewById(R.id.indietro2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AccountActivity.class);
                startActivity(i);
            }
        });

        ListView listviewconf = (ListView) findViewById(R.id.lista_configurazioni);
//        List list_conf = new ArrayList();
//        List list_set = new ArrayList();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();

        IGestoreAccount gestoreAccount = GestoreAccount.getInstance();
        final List<Configurazione> lista_configurazioni = gestoreAccount.getConfigurazioneAccount();

//        for (int i = 0; i < lista_configurazioni.size(); i++) {
//            list_conf.add("Configurazione: " + lista_configurazioni.get(i).getId());
//        }
//        adapter = new ArrayAdapter(ListaConfigurazioniActivity.this, android.R.layout.simple_list_item_1, list_conf);
//        listviewconf.setAdapter(adapter);

        for (int i = 0; i < lista_configurazioni.size(); i++) {
            String stringa = new String();
            for (Iterator<Setting> iterator = lista_configurazioni.get(i).getSetting().iterator(); iterator.hasNext(); ) {
                Setting s = iterator.next();
                if (s instanceof SettingOptional)
                    stringa = stringa +"Setting: " + ((SettingOptional) s).getNome() + "    Valore: " + s.getValore()+"\n";
                else
                    stringa = stringa+"Setting " + ((SettingSerie) s).getNome() + "    Valore: " + s.getValore()+"\n";
            }
            Map<String, String> datum = new HashMap<>(2);
            datum.put("id","Configurazione: "+lista_configurazioni.get(i).getId().toString());
            datum.put("setting",stringa);
            data.add(datum);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,data,android.R.layout.simple_list_item_2,new String[]{"id","setting"},new int[] {android.R.id.text1,
                android.R.id.text2});
        listviewconf.setAdapter(adapter);
    }
}
