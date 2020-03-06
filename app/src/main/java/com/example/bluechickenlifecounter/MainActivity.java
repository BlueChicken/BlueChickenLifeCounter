package com.example.bluechickenlifecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int vidaInicial = 20;
    int numJogadores = 2;
    static int maxPlayers = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startStartingLifeButtons();

        startNumPlayersButtons();

        Button button_start = (Button) findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildActivity2.class);
                intent.putExtra("numJogadores", numJogadores);
                intent.putExtra("vidaInicial", vidaInicial);

                startActivity(intent);
            }
        });

    }

    private void startNumPlayersButtons () {

        final TextView tv_numPlayers = findViewById(R.id.tv_num_jogadores);
        tv_numPlayers.setText(Integer.toString(numJogadores));

        Button button_addPlayer = (Button) findViewById(R.id.button_add_player);
        button_addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numJogadores < maxPlayers) {
                    ++numJogadores;
                } else {
                    numJogadores = maxPlayers;
                    Toast toast = Toast.makeText(getApplicationContext(), "É permitido um máximo de " + maxPlayers + " jogadores", Toast.LENGTH_SHORT);
                    toast.show();
                }

                tv_numPlayers.setText(Integer.toString(numJogadores));

            }
        });

        Button button_removePlayer = (Button) findViewById(R.id.button_remove_player);
        button_removePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numJogadores > 2) {
                    --numJogadores;
                } else {
                    numJogadores = 2;
                    Toast toast = Toast.makeText(getApplicationContext(), "É necessário um mínimo de 2 jogadores", Toast.LENGTH_SHORT);
                    toast.show();
                }

                tv_numPlayers.setText(Integer.toString(numJogadores));

            }
        });
    }

    private void startStartingLifeButtons () {

        final TextView tv_startingLife = findViewById(R.id.tv_vida_inicial);
        tv_startingLife.setText(Integer.toString(vidaInicial));

        Button button_lifeTotal20 = (Button) findViewById(R.id.button_startinglife_20);
        button_lifeTotal20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaInicial = 20;
                tv_startingLife.setText(Integer.toString(vidaInicial));
            }
        });

        Button button_lifeTotal30 = (Button) findViewById(R.id.button_startinglife_30);
        button_lifeTotal30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaInicial = 30;
                tv_startingLife.setText(Integer.toString(vidaInicial));
            }
        });

        Button button_lifeTotal40 = (Button) findViewById(R.id.button_startinglife_40);
        button_lifeTotal40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaInicial = 40;
                tv_startingLife.setText(Integer.toString(vidaInicial));
            }
        });
    }



}
