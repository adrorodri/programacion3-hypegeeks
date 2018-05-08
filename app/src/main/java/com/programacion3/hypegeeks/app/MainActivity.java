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
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText enterUser;
    EditText enterPassword;
    String userValue;
    String passwordValue;
    List<String> usersList;
    List<String> passwordList;
    DBController dbController;

    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        String usernameFromPreferences = sharedPreferences.getString(KEY_USERNAME, "");
           if (!usernameFromPreferences.equals("")) {
               Intent intent = new Intent(this, MainMenuLayoutActivity.class);
               finish();
               startActivity(intent);
           }
        enterUser = findViewById(R.id.User);
        enterPassword = findViewById(R.id.Password);
        passwordList = new LinkedList<>();
        usersList = new LinkedList<>();
    }

    public void clickButtonClick(View view) {
        userValue = String.valueOf(enterUser.getText().toString().trim());
        passwordValue = String.valueOf(enterPassword.getText().toString().trim());
        Intent intent;

        switch (view.getId()) {
            case R.id.enter: {
                if (!userValue.equals("")){
                    if(!passwordValue.equals("")){

                         this.usersList.clear();
                         this.usersList.addAll(dbController.selectUsuario());

                         this.passwordList.clear();
                         this.passwordList.addAll(dbController.selectPassword());

                         if (usersList.contains(userValue)) {
                             if (usersList.get(passwordList.indexOf(userValue)).equals(passwordValue)) {

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(KEY_USERNAME, userValue);
                                editor.apply();

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