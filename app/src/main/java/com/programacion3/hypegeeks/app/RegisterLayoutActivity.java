package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterLayoutActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        editTextUsername = findViewById(R.id.textUserName);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

    }
    public void clickEnviar(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonRegister: {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_USERNAME, editTextUsername.getText().toString());
                editor.apply();
                Toast.makeText(this, "Username Vacio", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, MainMenuLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.selecionarpunto:{
                String usernameFromPreferences = sharedPreferences.getString(KEY_USERNAME, "No hay username");
                if (!usernameFromPreferences.equals("")) {
                    Toast.makeText(this, usernameFromPreferences, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Username Vacio", Toast.LENGTH_SHORT).show();
                }
                break;
            }

        }
    }
}
