package com.example.activity_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextPage extends AppCompatActivity {

    private static String TAG="Main-LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        Log.i(TAG,"onCreate - Next-page");

        final Intent _intent=getIntent();
        final Intent _intent1 = new Intent(this,MainActivity.class);
        TextView textView =findViewById(R.id.textView);
        String message = _intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
      //  textView.setText(message);
        final Button button1=findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(_intent1);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart- Next-page");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause- Next-page");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume- Next-page");
       
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop- Next-page");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart- Next-page");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"onDestroy- Next-page");
    }
}
