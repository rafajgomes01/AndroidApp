package com.example.dietmaker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietmaker.R;
import com.example.dietmaker.classes.ItemModel;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {
    private List<ItemModel> itemModels;
    private Context context;

    public ItemAdapter(Context context, List<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        private TextView txtTipo, txtHorario;
        CardView card;

        private ItemHolder(View view) {
            super(view);
            txtTipo = (TextView) view.findViewById(R.id.title);
            txtHorario = (TextView) view.findViewById(R.id.txtHorario);
            card = view.findViewById(R.id.cardDieta);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View items = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new ItemHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        //now creating model for adapter
        ItemModel itemModel = itemModels.get(position);
        final ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.txtTipo.setText(itemModel.getTitle());
        itemHolder.txtHorario.setText(itemModel.getBody());
        itemHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemModels.get(position).isOpen() == true) {
                    itemModels.get(position).setOpen(false);
                    notifyDataSetChanged();
                } else {
                    itemModels.get(position).setOpen(true);
                    notifyDataSetChanged();
                }
            }
        });
        if (itemModel.isOpen()) {
            itemHolder.txtHorario.setVisibility(View.VISIBLE);
        } else {
            itemHolder.txtHorario.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
