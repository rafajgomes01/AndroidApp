package com.example.dietmaker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietmaker.classes.DietaGanharPeso;
import com.example.dietmaker.R;

import java.util.List;

public class AdapterGanho extends RecyclerView.Adapter<AdapterGanho.MyViewHolder> {

    private List<DietaGanharPeso> listaDietaGanharPeso;

    public AdapterGanho(List<DietaGanharPeso> lista) {
        this.listaDietaGanharPeso = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DietaGanharPeso dietaGanharPeso = listaDietaGanharPeso.get(position);

        holder.horario.setText(dietaGanharPeso.getHorario());
        holder.titulo.setText(dietaGanharPeso.getTitulo());
        holder.conteudo.setText((dietaGanharPeso.getConteudo()));

        boolean isExpanded = listaDietaGanharPeso.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return listaDietaGanharPeso.size();
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
                    DietaGanharPeso dietaGanharPeso = listaDietaGanharPeso.get(getAdapterPosition());
                    dietaGanharPeso.setExpanded(!dietaGanharPeso.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
