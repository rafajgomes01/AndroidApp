package com.example.dietmaker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        //holder.foto.setImageResource(dietaGanharPeso.getFoto());
        holder.horario.setText(dietaPerderPeso.getHorario());
        holder.titulo.setText(dietaPerderPeso.getTitulo());
        holder.subtitulo.setText(dietaPerderPeso.getSubtitulo());
        holder.conteudo.setText((dietaPerderPeso.getConteudo()));

        boolean isExpanded = listaDietaPerder.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return listaDietaPerder.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //ImageView foto;
        TextView horario;
        TextView titulo;
        TextView subtitulo;
        TextView conteudo;
        ConstraintLayout expandableLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            //foto = itemView.findViewById(R.id.imgFoto);
            horario = itemView.findViewById(R.id.txtHorario);
            titulo = itemView.findViewById(R.id.txtTitulo);
            subtitulo = itemView.findViewById(R.id.txtSub);
            conteudo = itemView.findViewById(R.id.txtContent);

            titulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DietaPerderPeso dietaPerderPeso = listaDietaPerder.get(getAdapterPosition());
                    dietaPerderPeso.setExpanded(!dietaPerderPeso.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
