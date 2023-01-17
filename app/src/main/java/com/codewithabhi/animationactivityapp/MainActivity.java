package com.codewithabhi.animationactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    Button button;
    LottieAnimationView animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        animation = findViewById(R.id.animation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "Launched", Toast.LENGTH_SHORT).show();
                Toast toast = Toast.makeText(MainActivity.this, "Successful" , Toast.LENGTH_SHORT);
                //toast.getGravity();
                toast.show();
              animation.setVisibility(View.VISIBLE);
              button.setVisibility(View.INVISIBLE);
              getSupportActionBar().hide();
              getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
              animation.playAnimation();

                Thread td = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            Intent intent = new Intent(MainActivity.this , FinalActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }; td.start();

            }
        });
    }
}