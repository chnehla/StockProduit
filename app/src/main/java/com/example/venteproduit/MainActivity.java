package com.example.venteproduit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnAuth;
    FirebaseAuth mAuth;
    TextView email , password;


    EditText log,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnlogin);
        btnAuth = findViewById(R.id.buttoninscrit);
        email = findViewById(R.id.Loginemail);
        log=(EditText)findViewById(R.id.Loginemail);
        pw=(EditText)findViewById(R.id.pwd);
        password = findViewById(R.id.pwd);
        //Dans la méthode onCreate de mon activité j'ai obtenu l'instance partagée de l'objet FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(view -> {
            LoginUser();
           Intent intent = new Intent(MainActivity.this ,   Produitlist.class);
//           startActivity(intent);

        });
        btnAuth.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InscritUser.class);
            startActivity(intent);
        });
    }
        private void LoginUser() {

            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            if (TextUtils.isEmpty(emailText)) {
                email.setError("Email cannot be empty");
                email.requestFocus();
            } else if (TextUtils.isEmpty(passwordText)) {
                password.setError("Password cannot be empty");
                password.requestFocus();

        }else{
            mAuth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                public void onComplete(@NonNull Task<AuthResult> task){
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "User logged in successfulty", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Produitlist.class));
                    }else{
                        Toast.makeText(  MainActivity. this,  "Registtation Error:" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            }





            }
//    //Lors de l'initialisation de mon activité, j'ai vérifié  si l'utilisateur est actuellement connecté
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if (user == null) {
//            startActivity(new Intent(MainActivity.this, MainActivity.class));
//        }
//    }

//    public void exit(View v){
//        finish();
//    }
}



