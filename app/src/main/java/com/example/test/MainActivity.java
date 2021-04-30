package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_SETTINGS = "message_settings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences(MESSAGE_SETTINGS , Context.MODE_PRIVATE);
        int hasVisited = sp.getInt("hasVisited", 0);

        if (hasVisited == 0) {
            SharedPreferences.Editor e = sp.edit();
            e.putInt("hasVisited", 1);
            e.apply();
        }
        else if(hasVisited == 1) {
            SharedPreferences.Editor e = sp.edit();
            e.putInt("hasVisited", 2);
            e.apply();
        }
        else if(hasVisited == 2){
            SharedPreferences.Editor e = sp.edit();
            e.putInt("hasVisited", 3);
            Toast toast = Toast.makeText(getApplicationContext(), "Какое-то сообщение!", Toast.LENGTH_SHORT);
            toast.show();
            e.apply();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}