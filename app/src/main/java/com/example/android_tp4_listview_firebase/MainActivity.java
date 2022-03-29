package com.example.android_tp4_listview_firebase;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android_tp4_listview_firebase.models.Student;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView l;
    AutoCompleteTextView search;
    TextView fisrtName;
    TextView lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = findViewById(R.id.listnotes);

        search = findViewById(R.id.searchBar);
        search.setAdapter(new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,getNames(getStudents())));
        search.setThreshold(1);

        fisrtName = findViewById(R.id.name);
        lastName = findViewById(R.id.lname);

        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                String name = adapterView.getItemAtPosition(i).toString();
                int index = getIndex(name, getStudents());

                    Student s = getStudents().get(index);
                    Float[] data = getNotes(s);
                    fisrtName.setText(s.firstName);
                    lastName.setText(s.lastName);

                    ArrayAdapter<Float> arr = new ArrayAdapter<Float>(MainActivity.this, R.layout.custom_adapter,data);
                    l.setAdapter(arr);




            }
        });



    }





    ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Amyr","Fezzeni",10,12,9,18,19,15));

        students.add(new Student("name 2","lname 2",5,10,19,8,7,11));

        students.add(new Student("name 3","lname 3",10,12,9,18,19,15));

        students.add(new Student("name 4","lname 4",10,12,9,18,19,15));
        return students;
    }

    Float [] getNotes(Student s){
        Float notes [] = {s.python, s.java, s.flutter,s.angular,s.database};
        return notes;
    }
    ArrayList<String> getNames(ArrayList<Student> students){
        ArrayList<String> names  = new ArrayList<String>();
        for (Student s : students){
            names.add(s.firstName+" "+s.lastName);
        }

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