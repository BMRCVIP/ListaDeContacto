package com.example.pantallaadicional.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pantallaadicional.R;
import com.example.pantallaadicional.entityes.ContactApi;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;
import java.util.List;

public class APIContactsAdapter extends RecyclerView.Adapter {
    List<ContactApi> datos;
    public APIContactsAdapter(List<ContactApi> datos) {
        this.datos=datos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_apicontact,parent,false);
        return new APIContacViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvName = holder.itemView.findViewById(R.id.tvname);
        tvName.setText(datos.get(position).name);

        TextView tvLastName = holder.itemView.findViewById(R.id.tvlastname);
        tvLastName.setText(datos.get(position).lastname);

        ImageView ivContacApi = holder.itemView.findViewById(R.id.ivContacApi);
        Picasso.get().load("https://cdn.pixabay.com/photo/2017/02/23/13/05/avatar-2092113_1280.png").into(ivContacApi);


    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    static class APIContacViewHolder extends RecyclerView.ViewHolder{

        public APIContacViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
