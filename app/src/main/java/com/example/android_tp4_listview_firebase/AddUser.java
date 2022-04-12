package com.example.android_tp4_listview_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_tp4_listview_firebase.models.Student;
import com.example.android_tp4_listview_firebase.services.DatabaseService;

public class AddUser extends AppCompatActivity {
    Button valider;
    EditText firstname;
    EditText lastname;
    EditText android;
    EditText flutter;
    EditText java;
    EditText python;
    EditText database;
    EditText angular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        android  = findViewById(R.id.androidtx);
        flutter = findViewById(R.id.fluttertx);
        java = findViewById(R.id.javatx);
        python = findViewById(R.id.pythontx);
        database = findViewById(R.id.databasetx);
        angular = findViewById(R.id.angulartx);

        valider = findViewById(R.id.validerbtn);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstname.getText().toString().isEmpty() ||
                    lastname.getText().toString().isEmpty() ||
                    android.getText().toString().isEmpty() ||
                    flutter.getText().toString().isEmpty() ||
                    java.getText().toString().isEmpty() ||
                    python.getText().toString().isEmpty() ||
                    database.getText().toString().isEmpty() ||
                    angular.getText().toString().isEmpty()){
                    Toast.makeText(AddUser.this, "please fill all fields", Toast.LENGTH_LONG).show();
                }else{
                    Student newUser = new Student(
                            firstname.getText().toString(),
                            lastname.getText().toString(),
                            Float.parseFloat(database.getText().toString()),
                            Float.parseFloat(android.getText().toString()),
                            Float.parseFloat(angular.getText().toString()),
                            Float.parseFloat(flutter.getText().toString()),
                            Float.parseFloat(python.getText().toString()),
                            Float.parseFloat (java.getText().toString())
                    );
                    DatabaseService.setData(newUser);
                    AddUser.this.finish();
                }
            }
        });
    }
}