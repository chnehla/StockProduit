package com.example.venteproduit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class choix_produit extends AppCompatActivity {

    ListView lst;
    EditText id;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_produit);
        lst=(ListView)findViewById(R.id.lsv);
        id=(EditText)findViewById(R.id.idp);
        btn=(Button)findViewById(R.id.buttonach);

}
//      AlertDialog.Builder Builder = new AlertDialog.Builder(this);
//       Builder.setTitle("confirme achat");
//      Builder.setMessage("Vous étre sur d'acheter ce produit");
//       Builder.setPositiveButton("J'Achéte", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//               String IDD=id.getText().toString();
//
//                if (res>0){
//                  Intent intent = new Intent(choix_produit.this, acceuil_p.class);
//                  startActivity(intent);
//                   Toast.makeText(choix_produit.this, "Ce produit A Acheter avec succée", Toast.LENGTH_SHORT).show();
//               }
//               else{
//                   Toast.makeText(choix_produit.this, "Ce produit n'exist pas verifier l'ID", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//      });
//        Builder.setNegativeButton("annuler", new DialogInterface.OnClickListener() {
//         @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//           }
//       });
//        final AlertDialog dialog = Builder.create();
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//           public void onClick(View v) {
//
//               if (id.getText().toString().equals(""))
//               {
//                   Toast.makeText(choix_produit.this,"Entrer l'ID du produit SVP ",Toast.LENGTH_SHORT).show();
//
//               }
//               else {
//                    dialog.show();
//              }
//
//            }
//        });
//
//
//    }
//
//
//
//    public void afficheunproduit(){
//        ArrayList<String> listData =db.selectunproduit(id.getText().toString());
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listData);
//        lst.setAdapter(arrayAdapter);
//    }
//
//   public  void cherche(View v){
//
//       if (id.getText().toString().equals(""))
//        {
//            Toast.makeText(choix_produit.this,"Entrer l'ID du produit SVP ",Toast.LENGTH_SHORT).show();
//
//       }
//        else {
//            afficheunproduit();
//        }
//    }
//
//
//
//
//
//
//
//    public void exit(View v){
//        finish();
//    }

}

