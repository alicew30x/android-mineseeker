package com.example.alison.portstarboard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button leftButton, rightButton;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = (Button) findViewById(R.id.leftBtn);
        rightButton = (Button) findViewById(R.id.rightBtn);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();
        if (v == leftButton) {
            Toast.makeText(context, "Port (left) is red", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Port (left) is red");
        }
        else if (v == rightButton) {
            Toast.makeText(context, "Port (right) is green", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Port (right) is green");
        }
    }
}
