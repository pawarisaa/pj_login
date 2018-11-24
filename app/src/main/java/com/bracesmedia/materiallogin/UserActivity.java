package com.bracesmedia.materiallogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity{

    TextView welcomeuser;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent =getIntent();
        String user = intent.getStringExtra("username");
        welcomeuser = findViewById(R.id.welcomeUser);
        welcomeuser.setText("welcome "+user);

    }
}
