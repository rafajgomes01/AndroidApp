package com.example.dietmaker.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dietmaker.R;
import com.example.dietmaker.classes.DietaPerderPeso;
import com.example.dietmaker.classes.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddNovaDieta extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    DatabaseReference user = referencia.child("user");
    private EditText editTitulo;
    private EditText editHorario;
    private EditText editCont;
    private int hora, minutos;
    private Button btnHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nova_dieta);

        editTitulo = findViewById(R.id.editAlterTitulo);
        editHorario = findViewById(R.id.editAlterHorario);
        editCont = findViewById(R.id.editAlterCont);
        btnHora = findViewById(R.id.btnHorario);
        btnHora.setOnClickListener(this);
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
        } else {
            Usuario usuario = new Usuario();
            usuario.setUid(FirebaseAuth.getInstance().getUid());

            DatabaseReference dieta = user.child(usuario.getUid());
            dieta.push().setValue(dietaPerderPeso);

            finish();
        }
    }

    @Override
    public void onClick(View view) {
        final Calendar c = Calendar.getInstance();
        hora = c.get(Calendar.HOUR_OF_DAY);
        minutos = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                editHorario.setText(hourOfDay+":"+minute);
            }
        },hora,minutos,true);
        timePickerDialog.show();
    }
}
