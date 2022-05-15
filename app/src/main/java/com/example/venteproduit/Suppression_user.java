package com.example.venteproduit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Suppression_user extends AppCompatActivity {

    Button btns;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    EditText pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppression_user);
        pw = (EditText) findViewById(R.id.pwd);
        btns = (Button) findViewById(R.id.btnsupp);
        firebaseAuth =FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();

        btns.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Suppression_user.this);
                dialog.setTitle("t'es sure ?");
                dialog.setMessage("Deleting this account will result in completly removing  your"+"account from the system and you won't be able to access the app ");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Suppression_user.this,"Account deleted",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Suppression_user.this ,   MainActivity.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(Suppression_user.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Suppression_user.this ,   MainActivity.class);
                                    startActivity(intent);
                                }

                            }
                        });

                    }
                });

                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog= dialog.create();
                alertDialog.show();
            }
        });


    }

//    public void exit(View v){
//        finish();
//    }

}

