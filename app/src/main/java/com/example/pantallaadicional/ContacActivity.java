package com.example.pantallaadicional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pantallaadicional.adapters.ContactAdapter;
import com.example.pantallaadicional.adapters.StringAdapter;
import com.example.pantallaadicional.entityes.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContacActivity extends AppCompatActivity {

    private RecyclerView rvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contac);

        List<Contact> contactos= new ArrayList<>();

        Contact contact = new Contact();
        contact.id=1;
        contact.nombre="Carlos";
        contact.apellido="Alberto";
        contact.imgURL="https://cdn.pixabay.com/photo/2017/02/23/13/05/avatar-2092113_1280.png";
        contactos.add(contact);

        Contact contact2 = new Contact();
        contact2.nombre="Sofia";
        contact2.apellido="Francisca";
        contact2.imgURL="https://img.icons8.com/color/480/avatar.png";
        contactos.add(contact2);

        rvContact = findViewById(R.id.rvContacts);
        rvContact.setLayoutManager(new LinearLayoutManager(this));
        rvContact.setAdapter(new ContactAdapter(contactos));
    }
}