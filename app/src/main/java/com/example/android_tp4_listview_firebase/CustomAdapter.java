package com.example.android_tp4_listview_firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomAdapter extends ArrayAdapter{

    Activity context;
    Float[] notes;

    CustomAdapter(Activity cntx, Float[] notes){
        super(cntx, R.layout.custom_adapter, notes);
        this.context = cntx;
        this.notes = notes;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){



        final View result;



            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView =  inflater.inflate(R.layout.custom_adapter, parent, false);

        TextView note = (TextView) convertView.findViewById(R.id.note);
        ImageView image = (ImageView) convertView.findViewById(R.id.img);


        result = convertView;



        Float _note =  notes[position];
        String n = _note.toString();
        note.setText(n);

        if(_note >= 10){
            image.setImageResource(R.drawable.happy);
        }
        else{
            image.setImageResource(R.drawable.sad);
        }
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, getMessage(position, _note), Toast.LENGTH_LONG).show();
            }
        });
        return result;
    }


String getMessage(int index, float note){
        String result = "";

    switch (index){
        case 0:
            result += "Python :";break;
        case 1:
            result += "Java :";break;
        case 2:
            result += "Flutter :";break;
        case 3:
            result += "Database :";break;
        case 4:
            result += "Angular :";break;
        default:
            break;
    }
    if (note >=10){
        result += " Success";
    }else{
        result += " Failed";
    }
        return result;
}


}
