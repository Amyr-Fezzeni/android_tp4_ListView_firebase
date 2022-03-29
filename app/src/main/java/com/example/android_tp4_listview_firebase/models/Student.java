package com.example.android_tp4_listview_firebase.models;

import java.util.HashMap;
import java.util.Objects;

public class Student {
    public String firstName;
    public String lastName;
    public float database;
    public float android;
    public float flutter;
    public float python;
    public float java;
    public float angular;

    public Student(String firstname,String lastname, float database, float android, float angular, float flutter, float python, float java){
        this.firstName = firstname;
        this.lastName = lastname;
        this.database = database;
        this.angular = angular;
        this.android = android;
        this.flutter = flutter;
        this.python = python;
        this.java = java;
    }
    public Student(HashMap<String, String> data){
        this.firstName = data.get("firstName");
        this.lastName = data.get("lastName");
        this.database = Float.parseFloat(Objects.requireNonNull(data.get("database")));
        this.angular = Float.parseFloat(Objects.requireNonNull(data.get("angular")));
        this.android = Float.parseFloat(Objects.requireNonNull(data.get("android")));
        this.flutter =Float.parseFloat(Objects.requireNonNull(data.get("flutter")));
        this.python =Float.parseFloat(Objects.requireNonNull(data.get("python")));
        this.java = Float.parseFloat(Objects.requireNonNull(data.get("java")));
    }
    public HashMap<String, Object> toJson(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("firstName", firstName);
        data.put("lastName",lastName );
        data.put("database",database );
        data.put("angular",angular );
        data.put("android",android );
        data.put("flutter",flutter );
        data.put("python",python );

        data.put("java",java );
        return data;
    }

}
