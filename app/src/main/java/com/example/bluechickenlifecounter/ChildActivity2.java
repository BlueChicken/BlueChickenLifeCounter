package com.example.bluechickenlifecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChildActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child2);

        TextView tv_resultadoVidaInicial = findViewById(R.id.tv_resultado_starting_life);
        TextView tv_resultadoNumJogadores = findViewById(R.id.tv_resultado_num_jogadores);

        Intent intent = getIntent();

        int numJogadores = intent.getIntExtra("numJogadores", 0);
        int vidaInicial = intent.getIntExtra("vidaInicial", 0);


        tv_resultadoNumJogadores.setText(Integer.toString(numJogadores));

        tv_resultadoVidaInicial.setText(Integer.toString(vidaInicial));

        Button button_backToMain = (Button) findViewById(R.id.button_back_to_main);
        button_backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        LinearLayout layout_moduleParent = findViewById(R.id.parent_modules);

        LayoutInflater layoutInflater = getLayoutInflater();

        /*


        View module = getLayoutInflater().inflate(R.layout.test_module, null);
        layout_moduleParent.addView(module);
        */

        for (int i = 0; i < numJogadores; i++) {
            View module = layoutInflater.inflate(R.layout.test_module, layout_moduleParent);
            System.out.println(Integer.toString(i));
        }




    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }



}
