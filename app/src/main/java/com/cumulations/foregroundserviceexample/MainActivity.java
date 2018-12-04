package com.cumulations.foregroundserviceexample;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
    }

    public void startService(View view) {
        String body=editText.getText().toString();
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        serviceIntent.putExtra("body",body);
//        startService(serviceIntent);
        ContextCompat.startForegroundService(this,serviceIntent);
    }

    public void stopService(View view) {
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        stopService(serviceIntent);
    }
}
