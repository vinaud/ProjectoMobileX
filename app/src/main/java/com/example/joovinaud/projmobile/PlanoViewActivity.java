package com.example.joovinaud.projmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlanoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plano_view);
    }

    protected void verExercicio(View v)
    {
        Intent i = new Intent(v.getContext(), AtividadeActivity.class);
        startActivity(i);
    }
}
