package com.example.bluechickenlifecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int startingLife = 20;
    int numPlayers = 2;
    static int maxPlayers = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_startingLife = findViewById(R.id.tv_vida_inicial);
        tv_startingLife.setText(Integer.toString(startingLife));

        final TextView tv_numPlayers = findViewById(R.id.tv_num_jogadores);
        tv_numPlayers.setText(Integer.toString(numPlayers));

        Button button_lifeTotal20 = (Button) findViewById(R.id.button_startinglife_20);
        button_lifeTotal20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startingLife = 20;
                tv_startingLife.setText(Integer.toString(startingLife));
            }
        });

        Button button_lifeTotal30 = (Button) findViewById(R.id.button_startinglife_30);
        button_lifeTotal30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startingLife = 30;
                tv_startingLife.setText(Integer.toString(startingLife));
            }
        });

        Button button_lifeTotal40 = (Button) findViewById(R.id.button_startinglife_40);
        button_lifeTotal40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startingLife = 40;
                tv_startingLife.setText(Integer.toString(startingLife));
            }
        });

        Button button_addPlayer = (Button) findViewById(R.id.button_add_player);
        button_addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numPlayers < maxPlayers) {
                    ++numPlayers;
                } else {
                    numPlayers = maxPlayers;
                    Toast toast = Toast.makeText(getApplicationContext(), "É permitido um máximo de " + maxPlayers + " jogadores", Toast.LENGTH_SHORT);
                    toast.show();
                }

                tv_numPlayers.setText(Integer.toString(numPlayers));

            }
        });

        Button button_removePlayer = (Button) findViewById(R.id.button_remove_player);
        button_removePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numPlayers > 2) {
                    --numPlayers;
                } else {
                    numPlayers = 2;
                    Toast toast = Toast.makeText(getApplicationContext(), "É necessário um mínimo de 2 jogadores", Toast.LENGTH_SHORT);
                    toast.show();
                }

                tv_numPlayers.setText(Integer.toString(numPlayers));

            }
        });


    }



}
