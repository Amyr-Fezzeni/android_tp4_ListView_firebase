package com.example.android_tp4_listview_firebase.services;

import androidx.annotation.NonNull;

import com.example.android_tp4_listview_firebase.models.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class DatabaseService {
    static public FirebaseFirestore db = FirebaseFirestore.getInstance();
    static ArrayList<Student> students = new ArrayList<>();
    static public void setData(Student s) {

        db.collection("users")
                .add(s.toJson())
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error adding document"+e);
                    }
                });
    }
    static public ArrayList<Student>getStudents() {return students;}
    static public void getData() {
        students = new ArrayList<>();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                System.out.println(document.getId() + " => " + document.getData());
                                students.add(new Student(document.getData()));

                            }

                        } else {
                            System.out.println("Error getting documents."+ task.getException());
                        }
                    }
                });

    }


}
