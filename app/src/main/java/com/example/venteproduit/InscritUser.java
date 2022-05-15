package com.example.venteproduit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InscritUser extends AppCompatActivity {

    EditText n,p,nu,lo,pw,cpw;
    FirebaseAuth mAuth;
    Button btninscrit;
//    FirebaseDatabase rootNode;
//    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscrit_user1);
        n = (EditText) findViewById(R.id.nom);
        p = (EditText) findViewById(R.id.prenom);
        nu = (EditText) findViewById(R.id.num);
        lo = (EditText) findViewById(R.id.regemail);
        pw = (EditText) findViewById(R.id.psswd);
        cpw = (EditText) findViewById(R.id.cnfpsswd);
        btninscrit =  findViewById(R.id.btn_inscrit);
        mAuth = FirebaseAuth.getInstance();



        btninscrit.setOnClickListener(view ->{
            createUser();

        });
    }
    private void createUser() {
        String nom = n.getText().toString();
        String prenom = p.getText().toString();
        String numero = nu.getText().toString();
        String email = lo.getText().toString();
        String password = pw.getText().toString();
        String confirmpwd = cpw.getText().toString();
        if (TextUtils.isEmpty(email)) {
            lo.setError("Email cannot be empty");
            lo.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            pw.setError("Password cannot be empty");
            pw.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(InscritUser.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                        rootNode =FirebaseDatabase.getInstance();
//                        reference= rootNode.getReference("Users");
//                        reference.setValue("First Data Storage");
                        startActivity(new Intent(InscritUser.this, MainActivity.class));
                    } else {
                        Toast.makeText(InscritUser.this, "Registration Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


    public void exit (View v){
        finish();
    }
}
