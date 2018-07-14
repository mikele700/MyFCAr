package com.example.unina.myfcar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.unina.myfcar.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = (Button) findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AccountActivity.class);

                EditText email = (EditText) findViewById(R.id.email_insert);
                EditText pass = (EditText) findViewById(R.id.password_insert);

                Bundle data = new Bundle();
                data.putString("email",email.getText().toString());
                data.putString("pass",pass.getText().toString());

                i.putExtras(data);
                startActivity(i);
            }
        });
    }
}
