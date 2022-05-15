package com.example.venteproduit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;

public class Produitlist extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Produits> list;
    Produits produits;
    private Button startServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produitlist);

         recyclerView = findViewById(R.id.Produitlist);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

         FirebaseRecyclerOptions<Produits> options =
                 new FirebaseRecyclerOptions.Builder<Produits>()
                         .setQuery(FirebaseDatabase.getInstance().getReference().child("ListeProduits"), Produits.class)
                         .build();

         myAdapter = new MyAdapter(options);
         recyclerView.setAdapter(myAdapter);

        //on va ajouter dans manifest file service class et enfin executer l'application
        //when i click  and than i remove the app countdown timer is still ticking
        startServiceButton=findViewById(R.id.servicebtn);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplication(),MyService.class));
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    public void onStop(){
        super.onStop();
        myAdapter.stopListening();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.user_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.userD:
                Intent intent = new Intent(Produitlist.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Produitlist.this, "Déconnexion affecter", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ajoutp:
//                afficheproduit();
                Intent intent1 = new Intent(Produitlist.this, Ajout_Produit.class);
                startActivity(intent1);
                Toast.makeText(Produitlist.this, "Espace de publier", Toast.LENGTH_SHORT).show();

                break;
            case R.id.userS:
                Intent intent2 = new Intent(Produitlist.this, Suppression_user.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}