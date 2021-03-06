package com.programacion3.hypegeeks.app;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
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
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    EditText enterUser;
    EditText enterPassword;
    String userValue;
    String passwordValue;
    List<DatosLogIn> usersList;
    DBController dbController;
  //  LenadoDeDBAlbum llenadoDeDBAlbum;

    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";

    private static final int RC_CAMERA_AND_LOCATION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llenadoDeDBAlbum = new LenadoDeDBAlbum();
       // llenadoDeDBAlbum.LlenadoAlbum();
        dbController = new DBController(this, "Programacion3.db", null, 1);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        String usernameFromPreferences = sharedPreferences.getString(KEY_USERNAME, "");
           if (!usernameFromPreferences.equals("")) {
               Intent intent = new Intent(this, MainMenuLayoutActivity.class);
               finish();
               startActivity(intent);
           }
        enterUser = findViewById(R.id.User);
        enterPassword = findViewById(R.id.Password);
        usersList = new LinkedList<>();

        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        EasyPermissions.requestPermissions(
                new PermissionRequest.Builder(this, RC_CAMERA_AND_LOCATION, perms)
                        .build());
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
                         this.usersList.addAll(dbController.selectUsuarioPassword());

                         for(DatosLogIn usuario : this.usersList) {
                             if (usuario.getUsuario().equals(userValue)) {
                                 if (usuario.getPassword().equals(passwordValue)) {
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
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "PERMISOS ACEPTADOS!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "PERMISOS RECHAZADOS!", Toast.LENGTH_SHORT).show();
        // Close the app, as we don't have permissions to use it. App may crash!
        finish();
    }
}