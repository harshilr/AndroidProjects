package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.carrental.MainActivity;
import com.example.carrental.R;

public class SplashScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGTH=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.splashScreenTheme);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent _intent = new Intent(SplashScreen.this, MainActivity.class);

                SplashScreen.this.startActivity(_intent);
                SplashScreen.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);

    }
}
