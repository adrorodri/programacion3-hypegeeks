package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterLayoutActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editEmailUser;
    EditText editTelefonoUser;
    EditText editPasswordUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        editEmailUser = findViewById(R.id.textEmailUser);
        editTelefonoUser = findViewById(R.id.textPhoneUser);
        editPasswordUser = findViewById(R.id.textPasswordUser);
        editTextUsername = findViewById(R.id.textUserName);
    }
    public void clickEnviar(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonRegister: {
                if(!editTelefonoUser.getText().toString().equals("") && !editPasswordUser.getText().toString().equals("")
                        && !editTextUsername.getText().toString().equals("") && !editEmailUser.getText().toString().equals("") ) {
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Datos Incompletos", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.selecionarpunto:{
                break;
            }

        }
    }
}
