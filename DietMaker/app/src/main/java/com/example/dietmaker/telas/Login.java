package com.example.dietmaker.telas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.dietmaker.MainActivity;
import com.example.dietmaker.R;
import com.example.dietmaker.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {

    private FirebaseAuth usuario;
    private FirebaseAuth.AuthStateListener firebaseAuthListenner;
    EditText email, password;
    Button login, cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.usuario = FirebaseAuth.getInstance();
        this.email = findViewById(R.id.editEmail);
        this.password = findViewById(R.id.editPassword);
        this.login = findViewById(R.id.btnLogar);
        this.cadastro = findViewById(R.id.btnCadastrar);


    }

    public void login(View view) {
        String mail = email.getText().toString();
        String pass = password.getText().toString();
        if (mail.isEmpty()) {
            email.setError("Digite seu email");
            email.requestFocus();
        } else if (pass.isEmpty()) {
            password.setError("Digite sua senha");
            password.requestFocus();
        } else if (!mail.isEmpty() && !pass.isEmpty()) {
            usuario.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast toast = Toast.makeText(Login.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        startActivity(new Intent(Login.this, MainActivity.class));
                        finish();
                    }
                }
            });
        } else {
            Toast toast = Toast.makeText(Login.this, "Programador ruim demais", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void cadastro(View view) {
        String mail = email.getText().toString();
        String pass = password.getText().toString();
        if (mail.isEmpty()) {
            email.setError("Digite seu email");
            email.requestFocus();
        } else if (pass.isEmpty()) {
            password.setError("Digite sua senha");
            password.requestFocus();
        } else if (mail.isEmpty() && pass.isEmpty()) {
            Toast toast = Toast.makeText(Login.this, "Preencha os campos", Toast.LENGTH_SHORT);
            toast.show();
        } else if (!mail.isEmpty() && !pass.isEmpty()) {
            usuario.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast toast = Toast.makeText(Login.this, "Falha ao cadastrar", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(Login.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            });
        } else {
            Toast toast = Toast.makeText(Login.this, "Programador ruim demais", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}