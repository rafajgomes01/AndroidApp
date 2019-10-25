package com.example.dietmaker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietmaker.classes.DietaPerderPeso;
import com.example.dietmaker.R;

import java.util.List;

public class AdapterPerder extends RecyclerView.Adapter<AdapterPerder.MyViewHolder> {

    private List<DietaPerderPeso> listaDietaPerder;

    public AdapterPerder(List<DietaPerderPeso> lista) {
        this.listaDietaPerder = lista;
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
        DietaPerderPeso dietaPerderPeso = listaDietaPerder.get(position);

        holder.foto.setImageResource(dietaPerderPeso.getFoto());
        holder.horario.setText(dietaPerderPeso.getHorario());
        holder.tipo.setText(dietaPerderPeso.getTipo());
    }

    @Override
    public int getItemCount() {
        return listaDietaPerder.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        TextView horario;
        TextView tipo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.imgFoto);
            horario = itemView.findViewById(R.id.txtHorario);
            tipo = itemView.findViewById(R.id.txtTipo);
        }
    }
}
