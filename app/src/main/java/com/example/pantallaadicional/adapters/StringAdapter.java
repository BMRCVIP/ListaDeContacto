package com.example.pantallaadicional.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pantallaadicional.R;

import java.util.Date;
import java.util.List;

public class StringAdapter extends RecyclerView.Adapter {

    List<String> data;

    public StringAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    //necesito saber que recurso como layout estoy utilizando (string)
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView= inflater.inflate(R.layout.item_string, parent, false);
        return new StringViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvnombre = holder.itemView.findViewById(R.id.tvNombre);
        tvnombre.setText(data.get(position));
    }

    @Override
    //cuantos elementos quieres que te imprima en pantalla
    public int getItemCount() {
        return data.size();
    }

    class StringViewHolder extends RecyclerView.ViewHolder{
        public StringViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}

