package com.example.venteproduit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ajout_Produit extends AppCompatActivity {

    //Variables
    EditText pn, cp, pp;
    Button btnajout;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_produit);

        //Hooks to all xml elements in activity_ajout_produit.xml
        pn = findViewById(R.id.pnom);
        cp = findViewById(R.id.cprod);
        pp = findViewById(R.id.prixp);
        btnajout = findViewById(R.id.btn_ajprod);

        //Save data in FireBase on button click
        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("ListeProduits");

                // Get all the values
                String pnom = pn.getEditableText().toString();
                String cprod = cp.getEditableText().toString();
                String pprod = pp.getEditableText().toString();

                // Add in database
                Produits produits = new Produits(pnom, cprod, pprod);
                reference.child(pnom).setValue(produits);

                Toast.makeText(Ajout_Produit.this, "data added", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Ajout_Produit.this ,   Produitlist.class);
                startActivity(intent);
            }
        });

    }
}
