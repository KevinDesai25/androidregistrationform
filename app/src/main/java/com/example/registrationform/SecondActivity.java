package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent  intent = getIntent();

        String user = intent.getStringExtra("user");
        int age = intent.getIntExtra("age",0);
        boolean isChecked  = intent.getBooleanExtra("isCheked",false);

        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText("User :" + user + "\nage: " + age + "\nisCheked:" +isChecked );
    }
}
