package com.example.roywang.plans2nite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

    Button buttonLogin, buttonRegister;
    TextView textViewLogin, textViewSignupPromopt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
