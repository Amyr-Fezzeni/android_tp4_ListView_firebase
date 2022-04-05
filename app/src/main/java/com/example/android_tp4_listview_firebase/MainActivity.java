package com.example.android_tp4_listview_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import com.example.android_tp4_listview_firebase.models.Student;
import com.example.android_tp4_listview_firebase.services.DatabaseService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    ListView l;
    AutoCompleteTextView search;
    ArrayList<Student> students;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseService.getData();
        l = findViewById(R.id.listnotes);

        search = findViewById(R.id.searchBar);
        students = new ArrayList<>();

        DatabaseService.db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                students.add(new Student(document.getData()));
                            }
                            search.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.select_dialog_item,getNames(DatabaseService.getStudents())));
                            search.setThreshold(1);
                        } else {
                            System.out.println("Error getting documents."+ task.getException());
                        }
                    }
                });



        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                String name = adapterView.getItemAtPosition(i).toString();

                System.out.println(students.size());
                int index = getIndex(name, students);
                    Student s = students.get(index);
                    Float[] data = getNotes(s);
                    adapter = new CustomAdapter(MainActivity.this, data);
                    l.setAdapter(adapter);
            }
        });



    }


    Float [] getNotes(Student s){
        return new Float[] {s.python, s.java, s.flutter,s.angular,s.database};
    }
    ArrayList<String> getNames(ArrayList<Student> students){
        ArrayList<String> names  = new ArrayList<String>();
        for (Student s : students){
            names.add(s.firstName+" "+s.lastName);
        }
        System.out.println(names);
        return names;
    }
    int getIndex(String name,ArrayList<Student> students ){
        for (int i = 0; i< students.size(); i++){
            Student s = students.get(i);
            String n = s.firstName+" "+s.lastName;
            if (name.equals(n)){
                return i;
            }
        }
        return -1;
    }

}