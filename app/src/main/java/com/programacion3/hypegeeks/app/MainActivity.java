package com.programacion3.hypegeeks.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterUser = findViewById(R.id.User);
        enterPassword = findViewById(R.id.Password);

        users = new ArrayList<>();
        passwords = new ArrayList<>();
        users.add("camilo");   passwords.add("123");
        users.add("camila");   passwords.add("456");
        users.add("sergio");   passwords.add("789");
        users.add("jorge");   passwords.add("1011");
        users.add("vivian");   passwords.add("1213");
    }
    public void clickLogIn(View view) {
        userValue = String.valueOf(enterUser.getText());
        passwordValue = String.valueOf(enterPassword.getText());

        if(users.contains(userValue)) {
            if(passwords.get(users.indexOf(userValue)).equals(passwordValue)){

            } else {
                Toast.makeText(this, "Contrasenia incorrecta", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "usuario incorrecto", Toast.LENGTH_LONG).show();
        }

        //if(userValue.equals()) {
            Toast.makeText(this, "Live with honor, die with Glory", Toast.LENGTH_LONG).show();
      //  }else if (!accountValue.equals("overwatch@gmail.com")){
            Toast.makeText(this, "Incorret Account", Toast.LENGTH_SHORT).show();
        //}else if (!passwordValue.equals("123")){
            Toast.makeText(this, "Incorret Password", Toast.LENGTH_SHORT).show();
        }
    }
