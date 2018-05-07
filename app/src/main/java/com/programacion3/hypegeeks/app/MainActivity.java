package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText enterUser;
    EditText enterPassword;
    String userValue;
    String passwordValue;
    List<String> users;
    List<String> passwords;

    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        String usernameFromPreferences = sharedPreferences.getString(KEY_USERNAME, "No existe username!");
           if (!usernameFromPreferences.equals("")) {
                Intent intent = new Intent(this, MainMenuLayoutActivity.class);
               startActivity(intent);
               Toast.makeText(this, "esta lleno", Toast.LENGTH_SHORT).show();
           } else {
               setContentView(R.layout.activity_main);
               Toast.makeText(this, "esta vacio", Toast.LENGTH_SHORT).show();
           }
         //error = ImageView(R.drawable.ic_action_error);
        enterUser = findViewById(R.id.User);
        enterPassword = findViewById(R.id.Password);

        users = new ArrayList<>();
        passwords = new ArrayList<>();
        users.add("camilo");
        passwords.add("123");
        users.add("camila");
        passwords.add("456");
        users.add("sergio");
        passwords.add("789");
        users.add("jorge");
        passwords.add("1011");
        users.add("vivian");
        passwords.add("1213");

    }

    public void clickButtonClick(View view) {
        userValue = String.valueOf(enterUser.getText().toString());
        passwordValue = String.valueOf(enterPassword.getText().toString());
        Intent intent;

        switch (view.getId()) {
            case R.id.enter: {
                if (!userValue.equals("")){
                    if (!passwordValue.equals("")){
                        if (users.contains(userValue)) {
                            if (passwords.get(users.indexOf(userValue)).equals(passwordValue)) {

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(KEY_USERNAME, userValue);
                                editor.apply();
                                Toast.makeText(this, "Valor guardado correctamente!", Toast.LENGTH_SHORT).show();

                                intent = new Intent(this, MainMenuLayoutActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(this, "Contrasenia incorrecta", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "usuario incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this, "Introdusca una Contraseña", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Introdusca un Usuario", Toast.LENGTH_SHORT).show();
                }
              break;
            }
            case R.id.resgistro: {
                intent = new Intent(this, RegisterLayoutActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}