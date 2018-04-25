package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }
    public void clickEnviar(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonRegister: {
                intent = new Intent(this, MainMenuLayoutActivity.class);
                startActivity(intent);
            }
        }
    }
}
