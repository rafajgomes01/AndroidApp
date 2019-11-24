package com.example.dietmaker.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dietmaker.R;
import com.example.dietmaker.classes.DietaPerderPeso;
import com.example.dietmaker.classes.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNovaDieta extends AppCompatActivity {
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    DatabaseReference user = referencia.child("user");
    private EditText editTitulo;
    private EditText editHorario;
    private EditText editCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nova_dieta);

        editTitulo = findViewById(R.id.editAlterTitulo);
        editHorario = findViewById(R.id.editAlterHorario);
        editCont = findViewById(R.id.editAlterCont);
    }

    public void adicionar(View view) {
        DietaPerderPeso dietaPerderPeso = new DietaPerderPeso();
        dietaPerderPeso.setTitulo(editTitulo.getText().toString());
        dietaPerderPeso.setHorario(editHorario.getText().toString());
        dietaPerderPeso.setConteudo(editCont.getText().toString());
        dietaPerderPeso.setExpanded(false);

        String titulo = editTitulo.getText().toString();
        String horario = editHorario.getText().toString();
        String cont = editCont.getText().toString();

        if (titulo.isEmpty()) {
            editTitulo.setError("Preencha o titulo da dieta");
            editTitulo.requestFocus();
        } else if (horario.isEmpty()) {
            editHorario.setError("Preencha o horario");
            editHorario.requestFocus();
        } else if (cont.isEmpty()) {
            editCont.setError("Preencha o conteúdo");
            editCont.requestFocus();
        } else if (horario.length() < 5) {
            editHorario.setError("Preencha corretamente o horario");
            editHorario.requestFocus();
        } else {
            Usuario usuario = new Usuario();
            usuario.setUid(FirebaseAuth.getInstance().getUid());

            DatabaseReference dieta = user.child(usuario.getUid());
            dieta.push().setValue(dietaPerderPeso);

            finish();
        }
    }
}
