package com.example.joovinaud.projmobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText snome;
    private EditText email;
    private EditText senha;
    private EditText idade;
    private EditText csenha;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.editText);
        snome = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        senha = (EditText) findViewById(R.id.editText5);
        csenha = (EditText) findViewById(R.id.editText6);
        idade = (EditText) findViewById(R.id.editText4);

        sharedpreferences = getSharedPreferences("User", 0);
    }

    public void confCadastro(View v)
    {
        if(senha.getText().toString().equals(csenha.getText().toString()))
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("name", nome.getText().toString());
            editor.putString("sobrenome", snome.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("senha", senha.getText().toString());
            editor.putString("idade", idade.getText().toString());
            editor.commit();

            Context context = getApplicationContext();
            CharSequence text = "Cadastro concluido";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
        }

        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Senha não confirmada";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
