package com.example.joovinaud.projmobile;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer);
    }

    public void ver(View view) {
        Intent i = new Intent(this,AtividadeActivity.class);
        i.putExtra("id","1");
        startActivity(i);
    }

    public void ver2(View view) {
        Intent i = new Intent(this,AtividadeActivity.class);
        i.putExtra("id","2");
        startActivity(i);
    }

    public void ver3(View view) {
        Intent i = new Intent(this,AtividadeActivity.class);
        i.putExtra("id","3");
        startActivity(i);
    }

    public void ver4(View view) {
          Intent i = new Intent(this,AtividadeActivity.class);
        i.putExtra("id","4");
          startActivity(i);


    }
}
