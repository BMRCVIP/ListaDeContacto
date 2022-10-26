package com.example.pantallaadicional.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pantallaadicional.R;
import com.example.pantallaadicional.entityes.RazaPerro;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RazaPerrosAdapater extends RecyclerView.Adapter {

    List<RazaPerro> data;
    public RazaPerrosAdapater(List<RazaPerro> data)
    {
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_razaperros, parent, false);
        return new RazaPerrosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvRazaPerro = holder.itemView.findViewById(R.id.tvRazaPerro);
        tvRazaPerro.setText(data.get(position).name);

       ImageView ivRaza= holder.itemView.findViewById(R.id.ivRaza);
       Picasso.get().load(data.get(position).image.url).into(ivRaza);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class RazaPerrosViewHolder extends RecyclerView.ViewHolder{

        public RazaPerrosViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
