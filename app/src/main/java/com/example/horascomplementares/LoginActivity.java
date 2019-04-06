package com.example.horascomplementares;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{

    private EditText usuario;
    private EditText senha;
    private View mProgressView;
    private View mLoginFormView;
    private Button entrar;
    private TextView registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.form_login_usuario_Id);
        senha = findViewById(R.id.form_login_senha_Id);
        mLoginFormView = findViewById(R.id.login_scrollview_Id);
        mProgressView = findViewById(R.id.login_progressbar_Id);
        entrar = findViewById(R.id.botao_email_entrar_Id);
        registrar = findViewById(R.id.link_registrar_usuario_Id);

        //Logar no sistema
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = usuario.getText().toString();
                String password = senha.getText().toString();

                if( !emailValido(user) ){
                    Toast.makeText(LoginActivity.this, "Email Inválido!", Toast.LENGTH_LONG).show();
                }else if( !senhaValida(password) ){
                    Toast.makeText(LoginActivity.this, "Senha Inválida!", Toast.LENGTH_LONG).show();
                }

            }
        });

        //Registrar-se no sistema
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }

    //Verifica se no email digitado contem @
    private boolean emailValido(String email) {
        return email.contains("@");
    }

    //Verifica se a senha digitada contem mais que 4 caracteres
    private boolean senhaValida(String password) {
        return password.length() > 3;
    }



    //Mostra a interface do usuário de progresso e oculta o formulário de login.
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}

