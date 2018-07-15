package com.example.unina.myfcar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.unina.myfcar.R;
import com.example.unina.myfcar.account.GestoreAccount;
import com.example.unina.myfcar.iclient.IGestoreAccount;

import java.util.ArrayList;
import java.util.List;

import business.domain.Account;


public class ConfigurazioniAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurazioni_auto);

        ListView listview = (ListView) findViewById(R.id.list_associa);
        List list = new ArrayList();
        ArrayAdapter adapter;

        IGestoreAccount gestoreAccount = GestoreAccount.getInstance();
        List listaConf = gestoreAccount.getConfigurazioneAuto();
        for(int i=0;i<listaConf.size();i++) {
            list.add(gestoreAccount.getConfigurazioneAuto().get(i).getId());
        }
        adapter = new ArrayAdapter(ConfigurazioniAutoActivity.this, android.R.layout.simple_list_item_1,list);
        

    }
}
