package com.example.android_tp4_listview_firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter {

    Activity context;
    Float[] notes;

    CustomAdapter(Activity cntx, Float[] notes){
        super(cntx, R.layout.custom_adapter, notes);
        this.context = cntx;
        this.notes = notes;
    }
    @Override
    public View getView(int index, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View row = inflater.inflate(R.layout.custom_adapter, null);

        ImageView img = row.findViewById(R.id.img);
        TextView note = row.findViewById(R.id.note);


        Float _note =  notes[index];
        String n = _note.toString();
        note.setText(n);

        if(_note >= 10){
            img.setImageResource(R.drawable.coffee);
        }
        else{
            img.setImageResource(R.drawable.work);
        }

        return row;
    }





}
