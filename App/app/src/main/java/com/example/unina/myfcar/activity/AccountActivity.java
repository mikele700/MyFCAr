package com.example.unina.myfcar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.unina.myfcar.R;
import com.example.unina.myfcar.account.GestoreAccount;
import com.example.unina.myfcar.iclient.IGestoreAccount;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        TextView showemail = (TextView) findViewById(R.id.show_email);

        String email = getIntent().getStringExtra("email");
//        String pass = getIntent().getStringExtra("pass");

        showemail.setText(email);

        Button button = (Button) findViewById(R.id.configurazioniauto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ConfigurazioniAutoActivity.class);
                startActivity(i);
            }
        });

        Button button1 = (Button) findViewById(R.id.listaauto);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListaAutoActivity.class);
                startActivity(i);
            }
        });

        Button button2 = (Button) findViewById(R.id.listaconfigurazioni);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListaConfigurazioniActivity.class);
                startActivity(i);
            }
        });

        ImageButton button3 = (ImageButton) findViewById(R.id.logout);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IGestoreAccount gestoreAccount = GestoreAccount.getInstance();
                gestoreAccount.logout();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
