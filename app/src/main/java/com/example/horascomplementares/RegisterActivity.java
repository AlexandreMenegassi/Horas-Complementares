package com.example.horascomplementares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    //Objetos de referência ao firebase
    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = firebaseReferencia.child("user");

    //Atributos para cadastro
    private EditText nome;
    private EditText email;
    private EditText senha;
    private TextView confirmacao;

    //Botao de ação cadastrar
    private Button cadastrar;
    boolean jaCadastrado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nome = findViewById(R.id.form_register_name_Id);
        email = findViewById(R.id.form_register_email_Id);
        senha = findViewById(R.id.form_register_senha_Id);
        confirmacao = findViewById(R.id.form_register_confirmacao_Id);
        cadastrar = findViewById(R.id.botao_register_cadastrar_Id);
        final User user = new User();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar.setText("Voltar");
                if(  jaCadastrado ) botaoVoltar();
                if( !jaCadastrado ) jaCadastrado = cadastrarUsuario(user);
            }
        });
    }

    public boolean botaoVoltar(){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        return true;
    }

    public boolean cadastrarUsuario(User usuario){

        //Pegando valores digitados pelo usuário
        String name = nome.getText().toString();
        String eMail = email.getText().toString();
        String password = senha.getText().toString();

        //Setando valores do objeto
        usuario.setNome(name);
        usuario.setEmail(eMail);
        usuario.setSenha(password);
        usuario.setAdmin(1);

        //Criando usuário novo no firebase
        usuarioReferencia.child("").push().setValue(usuario);

        //Confirmação de usuario criado com sucesso
        confirmacao.setText("Cadastro Realizado com Sucesso");
        Toast.makeText(RegisterActivity.this, "Cadastro Realizado com Sucesso",Toast.LENGTH_SHORT).show();
        return true;
    }
}
