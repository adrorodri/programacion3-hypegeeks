package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenuLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
    }
    public void clickMainMenu(View view){
        Intent intent;
        switch (view.getId()) {
            case R.id.botonRepetidas: {
                intent = new Intent(this, RepeLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.aniadir:{
                intent = new Intent(this, ListAdds.class);
                startActivity(intent);
                break;
            }
        }
    }
}
