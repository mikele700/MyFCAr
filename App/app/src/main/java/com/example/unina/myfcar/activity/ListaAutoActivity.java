package com.example.unina.myfcar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.unina.myfcar.R;
import com.example.unina.myfcar.account.GestoreAccount;
import com.example.unina.myfcar.iclient.IGestoreAccount;

import java.util.ArrayList;
import java.util.List;

import business.domain.Auto;

public class ListaAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_auto);

        ImageButton button = (ImageButton) findViewById(R.id.indietro1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AccountActivity.class);
                startActivity(i);
            }
        });

        ListView listviewauto = (ListView) findViewById(R.id.lista_automobili);
        List list_auto = new ArrayList();
        ArrayAdapter adapter;

        IGestoreAccount gestoreAccount = GestoreAccount.getInstance();
        final List<Auto> parco_auto = gestoreAccount.getAutoAccount();
        
        for (int i = 0; i < parco_auto.size(); i++) {
            list_auto.add("Targa: " + parco_auto.get(i).getTarga() + "    Modello: " + parco_auto.get(i).getModello());
        }
        adapter = new ArrayAdapter(ListaAutoActivity.this, android.R.layout.simple_list_item_1, list_auto);
        listviewauto.setAdapter(adapter);
    }
}
