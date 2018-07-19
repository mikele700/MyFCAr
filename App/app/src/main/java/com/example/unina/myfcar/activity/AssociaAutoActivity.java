package com.example.unina.myfcar.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unina.myfcar.R;
import com.example.unina.myfcar.account.GestoreAccount;
import com.example.unina.myfcar.configurazioneauto.GestoreConfigurazioneAuto;
import com.example.unina.myfcar.iclient.IGestoreAccount;
import com.example.unina.myfcar.iclient.IGestoreConfigurazioneAuto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.domain.Auto;
import business.domain.Configurazione;
import business.server.iserver.IServerGestoreConfigurazioneAuto;
import lipermi.handler.CallHandler;
import lipermi.net.Client;

public class AssociaAutoActivity extends AppCompatActivity {

    private Auto auto_select;
    private Configurazione conf_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associa_auto);

        ListView listviewauto = (ListView) findViewById(R.id.lista_auto);
        ListView listviewconf = (ListView) findViewById(R.id.lista_conf);
        List list_auto = new ArrayList();
        List list_conf = new ArrayList();
        ArrayAdapter adapter;

        final IGestoreAccount gestoreAccount = GestoreAccount.getInstance();
        final List<Auto> parco_auto = gestoreAccount.getAutoAccount();
        final List<Configurazione> lista_configurazioni = gestoreAccount.getConfigurazioneAccount();

        for (int i = 0; i < parco_auto.size(); i++) {
            list_auto.add("Targa: " + parco_auto.get(i).getTarga() + "    Modello: " + parco_auto.get(i).getModello());
        }
        adapter = new ArrayAdapter(AssociaAutoActivity.this, android.R.layout.simple_list_item_1, list_auto);
        listviewauto.setAdapter(adapter);

        listviewauto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                auto_select = parco_auto.get(i);
            }
        });


        for (int i = 0; i < lista_configurazioni.size(); i++) {
            list_conf.add("Configurazione: " + lista_configurazioni.get(i).getId());
        }
        adapter = new ArrayAdapter(AssociaAutoActivity.this, android.R.layout.simple_list_item_1, list_conf);
        listviewconf.setAdapter(adapter);

        listviewconf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                conf_select = lista_configurazioni.get(i);
            }
        });

        Button button = (Button) findViewById(R.id.conferma);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connessione conn = new Connessione();
//                conn.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                conn.start();
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.indietro);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AccountActivity.class);
                Bundle data = new Bundle();
                data.putString("email", gestoreAccount.getAccount().getEmail());
                i.putExtras(data);
                startActivity(i);
            }
        });

    }



//    class Connessione extends AsyncTask<Void, Void, AssociaAutoActivity> {
    class Connessione extends Thread {
        @Override
//        protected AssociaAutoActivity doInBackground(Void... params)
        public void run(){
            Looper.prepare();
            try {
                CallHandler callHandler = new CallHandler();
//                Client clientca = new Client("192.168.1.62", 4455, callHandler);  //ip casa Davide
//                Client clientca = new Client("87.12.207.206", 4455, callHandler);  //ip pubblico Michele
                Client clientca = new Client("192.168.43.19", 4455, callHandler);  //hotspot telefono Davide
                IServerGestoreConfigurazioneAuto iserverca;
                iserverca = (IServerGestoreConfigurazioneAuto) clientca.getGlobal(IServerGestoreConfigurazioneAuto.class);

                IGestoreConfigurazioneAuto gestoreConfigurazioneAuto = GestoreConfigurazioneAuto.getInstance();
                IGestoreAccount gestorea = GestoreAccount.getInstance();

                String s = gestoreConfigurazioneAuto.associaAuto(gestorea.getAccount(),auto_select,conf_select,iserverca);
                Toast.makeText(AssociaAutoActivity.this,s,Toast.LENGTH_SHORT).show();

                clientca.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Looper.loop();
//            return null;
        }

    }
}
