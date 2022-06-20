package com.example.doctors_office_finals_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i = 0;
        Random random = new Random();

        do {
            if (random.nextBoolean()) {
                Log.i("19621655", "Error in logging. Try # " + ++i);
                Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
                SystemClock.sleep(random.nextInt(5000));
            } else {
                Toast.makeText(this, R.string.success, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PatientsActivity.class);
                startActivity(intent);
                break;
            }
        } while (true);
    }
}