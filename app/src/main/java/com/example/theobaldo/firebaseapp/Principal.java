package com.example.theobaldo.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Principal extends AppCompatActivity {

    private DatabaseReference firebasebaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioreferencia = firebasebaseReferencia.child("usuarios");
    private DatabaseReference produtoreferencia = firebasebaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        /*
        Produto produto = new Produto();
        produto.setDescricao("SmartPhone");
        produto.setCor("Marron");
        produto.setFabricante("LG");


        produtoreferencia.child("001").setValue(produto);
        */

        usuarioreferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
