package com.example.dietmaker.adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dietmaker.R;
import com.example.dietmaker.classes.DietaPerderPeso;
import com.example.dietmaker.classes.Usuario;
import com.example.dietmaker.telas.AlterarDieta;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;

public class AdapterNovaDieta extends RecyclerView.Adapter<AdapterNovaDieta.MyViewHolder> {
    private List<DietaPerderPeso> listaNovaDieta;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    DatabaseReference user = referencia.child("user");
    public AdapterNovaDieta(List<DietaPerderPeso> lista) {
        this.listaNovaDieta = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dieta_nova, parent, false);
        return new AdapterNovaDieta.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DietaPerderPeso dietaPerderPeso = listaNovaDieta.get(position);

        holder.horario.setText(dietaPerderPeso.getHorario());
        holder.titulo.setText(dietaPerderPeso.getTitulo());
        holder.conteudo.setText((dietaPerderPeso.getConteudo()));
        holder.itemView.setLongClickable(true);
        boolean isExpanded = listaNovaDieta.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return listaNovaDieta.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView horario;
        TextView titulo;
        TextView conteudo;
        ConstraintLayout expandableLayout;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            horario = itemView.findViewById(R.id.txtHorario);
            titulo = itemView.findViewById(R.id.txtTitulo);
            conteudo = itemView.findViewById(R.id.txtContent);

            titulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DietaPerderPeso dietaPerderPeso = listaNovaDieta.get(getAdapterPosition());
                    dietaPerderPeso.setExpanded(!dietaPerderPeso.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }

            });

            titulo.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Deseja realmente excluir?")
                            .setCancelable(false)
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    listaNovaDieta.remove(listaNovaDieta.get(getAdapterPosition()));
                                    notifyItemChanged(getAdapterPosition());
                                    Usuario usuario = new Usuario();
                                    usuario.setUid(FirebaseAuth.getInstance().getUid());

                                    DatabaseReference dieta = user.child(usuario.getUid());
                                    dieta.setValue(listaNovaDieta);
                                }
                            })
                            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return true;
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listaNovaDieta.add(listaNovaDieta.get(getAdapterPosition()));
                    notifyItemChanged(getAdapterPosition());
                    Usuario usuario = new Usuario();
                    usuario.setUid(FirebaseAuth.getInstance().getUid());

                    DatabaseReference dieta = user.child(usuario.getUid());
                    dieta.setValue(listaNovaDieta);
                    return true;
                }
            });

        }
    }


}
