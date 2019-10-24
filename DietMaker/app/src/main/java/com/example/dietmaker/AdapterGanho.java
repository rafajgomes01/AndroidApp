package com.example.dietmaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterGanho extends RecyclerView.Adapter<AdapterGanho.MyViewHolder> {

    private List<DietaGanho> listaDietaGanhos;

    public AdapterGanho(List<DietaGanho> lista) {
        this.listaDietaGanhos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        /*Button btn = itemLista.findViewById(jjhk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DietaGanho dietaGanho = listaDietaGanhos.get(position);

        holder.foto.setImageResource(dietaGanho.getFoto());
        //holder.dieta.setText(dietaGanho.getDieta());
        holder.horario.setText(dietaGanho.getHorario());
        holder.tipo.setText(dietaGanho.getTipo());
    }

    @Override
    public int getItemCount() {
        return listaDietaGanhos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        //TextView dieta;
        TextView horario;
        TextView tipo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.imgFoto);
            //dieta = itemView.findViewById(R.id.txtDieta);
            horario = itemView.findViewById(R.id.txtHorario);
            tipo = itemView.findViewById(R.id.txtTipo);
        }
    }
}
