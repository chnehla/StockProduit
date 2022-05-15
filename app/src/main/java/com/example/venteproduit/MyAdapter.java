package com.example.venteproduit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MyAdapter extends FirebaseRecyclerAdapter<Produits, MyAdapter.MyViewHolder>  {


    public MyAdapter(@NonNull FirebaseRecyclerOptions<Produits> options) {
        super(options);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.produit,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Produits produits) {
         holder.NomProduit.setText(produits.getNomProduit());
         holder.Catégorie.setText(produits.getCatégorie());
         holder.Prix.setText(produits.getPrix());
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView NomProduit, Catégorie, Prix;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            NomProduit= itemView.findViewById(R.id.nomProduit);
            Catégorie= itemView.findViewById(R.id.catProduit);
            Prix=itemView.findViewById(R.id.prixProduit);
        }
    }
}
