package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Button buttonMain,buttonEventPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMain = findViewById(R.id.buttonMain ) ;
        buttonEventPage  = findViewById(R.id.buttonEventPage  ) ;

        buttonMain.setOnClickListener(this);
        buttonEventPage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==buttonMain )
        {
            Toast.makeText(MainActivity .this, "Welcome Home !!", Toast.LENGTH_SHORT).show();
            Intent intentHome = new Intent(MainActivity .this,LoginActivity  .class);
            startActivity(intentHome );

        }
        else if(v==buttonEventPage  )
        {
            Toast.makeText(MainActivity .this, "Welcome to event creation page !!", Toast.LENGTH_SHORT).show();
            Intent intentEvent = new Intent(MainActivity .this,PlanInputActivity   .class);
            startActivity(intentEvent );

        }

    }
}

