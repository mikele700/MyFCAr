package com.example.unina.myfcar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.unina.myfcar.R;
import com.example.unina.myfcar.account.GestoreAccount;
import com.example.unina.myfcar.iclient.IGestoreAccount;

import java.util.ArrayList;
import java.util.List;

import business.domain.Account;
import business.domain.Auto;
import business.domain.ConfigurazioneAuto;


public class ConfigurazioniAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurazioni_auto);

        ListView listview = (ListView) findViewById(R.id.list_associa);
        List list = new ArrayList();
        ArrayAdapter adapter;

        IGestoreAccount gestoreAccount = GestoreAccount.getInstance();
        List<ConfigurazioneAuto> listaConf = gestoreAccount.getConfigurazioneAutoAccount();
        for(int i=0;i<listaConf.size();i++) {
            Auto auto = gestoreAccount.cercaAutoAccount(listaConf.get(i).getId());
            list.add("Targa: "+auto.getTarga()+"    Modello: "+auto.getModello()+"    Configurazione: "+listaConf.get(i).getConfigurazione().getId());
        }
        adapter = new ArrayAdapter(ConfigurazioniAutoActivity.this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.associa_auto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AssociaAutoActivity.class);
                startActivity(i);
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.indietro3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AccountActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }
}
