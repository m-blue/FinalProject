package com.example.blue.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String correctName = "Mark";
    String correctPassword = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtName = findViewById(R.id.idName);
        final TextView txtPassword = findViewById(R.id.idPassword);
        Button loginBtn = findViewById(R.id.loginButton);

        final Toast toast = null;

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!correctName.equals(txtName.getText().toString())){
                    toast.makeText(MainActivity.this,"Incorrect Name",Toast.LENGTH_LONG).show();
                }
                else if(!correctPassword.equals(txtPassword.getText().toString())){
                    toast.makeText(MainActivity.this, "Incorrect Password",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(MainActivity.this, MainClassList.class));
                    toast.makeText(MainActivity.this, "Login Successful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
