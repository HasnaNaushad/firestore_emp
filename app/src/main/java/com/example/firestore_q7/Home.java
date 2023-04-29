package com.example.firestore_q7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Home extends AppCompatActivity {

    EditText name,empid,address;
    Button Store;
    FirebaseFirestore Fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.name);
        empid = findViewById(R.id.Age);
        address = findViewById(R.id.adress);
        Store = findViewById(R.id.Store);
        Fstore = FirebaseFirestore.getInstance();

        Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String age1 = empid.getText().toString();
                String adress1 = address.getText().toString();

                Map<Object , String> User = new HashMap<>();
                User.put("name",name1);
                User.put("age",age1);
                User.put("adress",adress1);
                Fstore.collection("UserData").add(User).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(Home.this, "Data Stored Sucessfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Home.this, "Data Add Failed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });



    }
}