package com.example.dietmaker.telas;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.dietmaker.MainActivity;
import com.example.dietmaker.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void logar(View view) {
        usuario.signInWithEmailAndPassword("batata@gmail.com", "batata123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent it = new Intent(Login.this, MainActivity.class);
                    startActivity(it);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Erro ao logar usuário", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        });
    }

}
