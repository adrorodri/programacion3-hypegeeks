package com.example.admin.loginexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.programacion3.hypegeeks.app.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText enterCorreo;
    EditText enterContrasenia;
    String correoValue;
    String contraseniaValue;
    List<String> correos = new ArrayList<>();
    List<String> contrasenias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterCorreo = findViewById(R.id.correo);
        enterContrasenia = findViewById(R.id.contrasenia);
        //AgregarCORREOS Y CONTRASENIAS

    }
    public void clickLogIn(View view) {
        correoValue = String.valueOf(enterCorreo.getText());
        contraseniaValue = String.valueOf(enterContrasenia.getText());
        for(int i = 0; i>correos.size();i++){
            correos.add(i,correoValue);
            contrasenias.add(i,contraseniaValue);
            if(correos.get(i).equals(correoValue)) {
                if(contrasenias.get(i).equals(contraseniaValue)){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Contrasenia Incorecta", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Correo Incorrecto", Toast.LENGTH_SHORT).show();
            }

        }

    }
}