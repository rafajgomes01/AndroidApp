package com.example.dietmaker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietmaker.classes.DietaGanharPeso;
import com.example.dietmaker.classes.DietaPerderPeso;
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
        DietaGanharPeso dietaGanharPeso = listaDietaGanharPeso.get(position);

       // holder.foto.setImageResource(dietaGanharPeso.getFoto());
        holder.horario.setText(dietaGanharPeso.getHorario());
        holder.tipo.setText(dietaGanharPeso.getTipo());
    }

    @Override
    public int getItemCount() {
        return listaDietaGanharPeso.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       // ImageView foto;
        TextView horario;
        TextView tipo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           // foto = itemView.findViewById(R.id.imgFoto);
            horario = itemView.findViewById(R.id.txtHorario);
            tipo = itemView.findViewById(R.id.txtTipo);
        }
    }
}
