package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.LinkedList;
import java.util.List;

public class RegisterLayoutActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editEmailUser;
    EditText editTelefonoUser;
    EditText editPasswordUser;
    EditText editPuntoUser;
    List<Usuario> usuarioList;
    DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


        usuarioList = new LinkedList<>();
        editEmailUser = findViewById(R.id.textEmailUser);
        editTelefonoUser = findViewById(R.id.textPhoneUser);
        editPasswordUser = findViewById(R.id.textPasswordUser);
        editTextUsername = findViewById(R.id.textUserName);
        editPuntoUser = findViewById(R.id.textPuntoUser);
        dbController = new DBController(this, "Programacion3-hypegeeks.db", null, 1);

    }
    public void clickEnviar(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonRegister: {
                if(!editTelefonoUser.getText().toString().trim().equals("") && !editPasswordUser.getText().toString().trim().equals("")
                        && !editTextUsername.getText().toString().trim().equals("") && !editEmailUser.getText().toString().trim().equals("") &&
                        !editPuntoUser.getText().toString().trim().equals("")) {
                    boolean inserted = dbController.insertPersona(editTextUsername.getText().toString().trim(),
                        editEmailUser.getText().toString().trim(),editPasswordUser.getText().toString().trim(),
                        editPuntoUser.getText().toString().trim(),Integer.parseInt(editTelefonoUser.getText().toString().trim()));
                    if (inserted) {
                        intent = new Intent(this, MainActivity.class);
                       startActivity(intent);
                      Toast.makeText(this, "Insertado correctamente!", Toast.LENGTH_SHORT).show();
                    } else {
                      Toast.makeText(this, "Error insertando persona", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Datos Incompletos", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
