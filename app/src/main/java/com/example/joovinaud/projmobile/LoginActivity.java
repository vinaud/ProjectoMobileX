package com.example.joovinaud.projmobile;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {






    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);


        mPasswordView = (EditText) findViewById(R.id.password);


        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }




    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }




        protected void cadastroIntent(View view)
        {
            Intent i = new Intent(view.getContext(), CadastroActivity.class);
            startActivity(i);

        }

    public void logar(View view) {

        //criar metodo de verificar login
        Intent i = new Intent(view.getContext(), MainActivity.class);
        startActivity(i);
    }
}


