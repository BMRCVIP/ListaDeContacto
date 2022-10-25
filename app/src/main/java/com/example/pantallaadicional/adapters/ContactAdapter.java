package com.example.pantallaadicional.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pantallaadicional.R;
import com.example.pantallaadicional.entityes.Contact;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {

    List<Contact> datos;
    public ContactAdapter(List<Contact> datos){
        this.datos=datos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView= inflater.inflate(R.layout.item_contact, parent, false);
        return new ContactAdapter.ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvnombreContacto = holder.itemView.findViewById(R.id.tvnombreContacto);
        tvnombreContacto.setText(datos.get(position).nombre);

        TextView tvapellidoContacto = holder.itemView.findViewById(R.id.tvapellidoContacto);
        tvapellidoContacto.setText(datos.get(position).apellido);

        /*TextView tvnumerotelefono = holder.itemView.findViewById(R.id.tvnumeroContacto);
        tvnumerotelefono.setText(datos.get(position).numeroTelefono);*/

        ImageView ivImagen = holder.itemView.findViewById(R.id.ivImagen);
       // ivImagen.setImageResource(R.mipmap.ic_launcher);
        //Desde local
        //ivImagen.setImageResource(R.drawable.avatar);
        //Desde la web
        //Picasso.get().load("https://cdn.pixabay.com/photo/2017/02/23/13/05/avatar-2092113_1280.png").into(ivImagen);
        //1*1
        Picasso.get().load(datos.get(position).imgURL).into(ivImagen);
        //por si queremos aceder al contexto
        //holder.itemView.getContext();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
