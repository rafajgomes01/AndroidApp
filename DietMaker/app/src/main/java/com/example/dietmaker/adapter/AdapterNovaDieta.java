package com.example.dietmaker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dietmaker.R;
import com.example.dietmaker.classes.DietaPerderPeso;


import java.util.List;

public class AdapterNovaDieta extends RecyclerView.Adapter<AdapterNovaDieta.MyViewHolder> {
    private List<DietaPerderPeso> ListaNovaDieta;

    public AdapterNovaDieta(List<DietaPerderPeso> lista) {
        this.ListaNovaDieta = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dieta_nova, parent, false);
        return new AdapterNovaDieta.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DietaPerderPeso dietaPerderPeso = ListaNovaDieta.get(position);

        holder.horario.setText(dietaPerderPeso.getHorario());
        holder.titulo.setText(dietaPerderPeso.getTitulo());
        holder.conteudo.setText((dietaPerderPeso.getConteudo()));

        boolean isExpanded = ListaNovaDieta.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return ListaNovaDieta.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView horario;
        TextView titulo;
        TextView conteudo;
        ConstraintLayout expandableLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            horario = itemView.findViewById(R.id.txtHorario);
            titulo = itemView.findViewById(R.id.txtTitulo);
            conteudo = itemView.findViewById(R.id.txtContent);

            titulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DietaPerderPeso dietaPerderPeso = ListaNovaDieta.get(getAdapterPosition());
                    dietaPerderPeso.setExpanded(!dietaPerderPeso.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }


}
