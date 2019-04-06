package com.example.horascomplementares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        /*
        //Cadastro de Email e Senha
        firebaseAuth.createUserWithEmailAndPassword("teste@hotmail.com","teste12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("createUser", "Usuario criado com sucesso!");
                        } else {
                            Log.i("createUser", "Erro ao criar usuario.");
                        }
                    }
                });
        */

        /*
        //Logar no Sistema
        firebaseAuth.signInWithEmailAndPassword("teste@hotmail.com", "teste12345")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("signIn", "Usuario logado com sucesso!");
                        } else {
                            Log.i("signIn", "Erro ao logar no sistema.");
                        }
                    }
                });
        */

        //Delsogar Usuario do Sistema
        firebaseAuth.signOut();

        //Testar se o usuario está logado
        if (firebaseAuth.getCurrentUser() != null) {
            Log.i("verificaUsuario", "Usuario logado!");
        } else {
            Log.i("verificaUsuario", "Usuario deslogado.");
        }
    }

}

