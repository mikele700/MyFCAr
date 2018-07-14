package com.example.unina.myfcar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.unina.myfcar.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        TextView showemail = (TextView) findViewById(R.id.show_email);

        String email = getIntent().getStringExtra("email");
        String pass = getIntent().getStringExtra("pass");

        showemail.setText(email);

    }
}
