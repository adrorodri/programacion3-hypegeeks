package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RepeLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repetidas_layout);
    }
    public void clickRepetidas(View view){
        Intent intent;
        switch (view.getId()) {
            case R.id.add: {
                intent = new Intent(this, ListAdds.class);
                startActivity(intent);
            }
        }
    }
}
