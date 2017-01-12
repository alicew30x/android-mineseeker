package com.example.alison.portstarboard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button leftButton, rightButton, leftAnswerBtn, rightAnswerBtn;
    private Game gameSide;
    private TextView side;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate buttons
        leftButton = (Button) findViewById(R.id.leftBtn);
        rightButton = (Button) findViewById(R.id.rightBtn);
        leftAnswerBtn = (Button) findViewById(R.id.answerLeft);
        rightAnswerBtn = (Button) findViewById(R.id.answerRight);

        //instantiate textview to display side picked
        side = (TextView) findViewById(R.id.question_side);

        //set button listeners
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        leftAnswerBtn.setOnClickListener(this);
        rightAnswerBtn.setOnClickListener(this);

        //pick a side
        gameSide = new Game();
        setSide();
    }

    //set textview to corresponding side
    public void setSide() {
        if(gameSide.getChosenSideName() == "Port") {
            side.setText(getString(R.string.question_port));
        }
        else {
            side.setText(getString(R.string.question_starboard));
        }
    }

    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();

        switch(v.getId()) {
            case R.id.leftBtn:
                Toast.makeText(context, "Port (left) is red", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Port (left) is red");
                break;
            case R.id.rightBtn:
                Toast.makeText(context, "Port (right) is green", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Port (right) is green");
                break;
            case R.id.answerLeft:
                if (gameSide.checkIfCorrect(Game.Side.PORT)) {
                    Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "User guess of Port was correct.");
                    gameSide = new Game();
                    setSide();
                    break;
                }
                else {
                    Toast.makeText(context, "Incorrect :(", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "User guess of Port was incorrect.");
                    gameSide = new Game();
                    setSide();
                    break;
                }
            case R.id.answerRight:
                if(gameSide.checkIfCorrect(Game.Side.STARBOARD)) {
                    Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "User guess of Starboard was correct.");
                    gameSide = new Game();
                    setSide();
                    break;
                }
                else {
                    Toast.makeText(context, "Incorrect :(", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "User guess of Starboard was incorrect.");
                    gameSide = new Game();
                    setSide();
                    break;
                }

        }
    }
}
