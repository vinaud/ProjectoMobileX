package com.example.joovinaud.projmobile;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);


        mPasswordView = (EditText) findViewById(R.id.password);


        mLoginFormView = findViewById(R.id.login_form);

        sharedpreferences = getSharedPreferences("User", 0);

    }




    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }



    public void cadastrar(View view)
    {
        Intent i = new Intent(this,CadastroActivity.class);
        startActivity(i);
    }

    public void logar(View view) {
        String login = sharedpreferences.getString("email", null);
      //  System.out.print(login);
        String senha =  sharedpreferences.getString("senha", null);




        if(mEmailView.getText().toString().equals(login) && mPasswordView.getText().toString().equals(senha))
        {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("Login","true");
            i.putExtra("mail",login);

            startActivity(i);
            Toast.makeText(this, "Bem vindo(a) "+ login , Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Usuario ou senha invalidos", Toast.LENGTH_LONG).show();
        }

    }
}


