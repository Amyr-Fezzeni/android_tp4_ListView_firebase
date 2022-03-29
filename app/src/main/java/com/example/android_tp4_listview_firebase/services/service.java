package com.example.android_tp4_listview_firebase.services;

import com.example.android_tp4_listview_firebase.models.Student;

import java.util.ArrayList;

class ServiceStudents {

    ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Amyr","Fezzeni",10,12,9,18,19,15));

        students.add(new Student("name 2","lname 2",10,12,9,18,19,15));

        students.add(new Student("name 3","lname 3",10,12,9,18,19,15));

        students.add(new Student("name 4","lname 4",10,12,9,18,19,15));
        return students;
    }

   public ServiceStudents(){}
}
