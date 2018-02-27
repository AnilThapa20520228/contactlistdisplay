package com.example.nasa.contactlist;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);

        if(getIntent().hasExtra("uname")){
            String username=getIntent().getStringExtra("uname");
            setTitle("welcome "+ username);
        }

        String data="[\n" +
                "\t{\n" +
                "\t\"name\": \"Nikesh\",\n" +
                "\t\"phone\":\"9812302612\"\n" +
                "     },\n" +
                "     {\n" +
                "\t\"name\": \"Nikesh\",\n" +
                "\t\"phone\":\"9812302612\"\n" +
                "     },\n" +
                "     {\n" +
                "\t\"name\": \"Nikesh\",\n" +
                "\t\"phone\":\"9812302612\"\n" +
                "     },\n" +
                "     {\n" +
                "\t\"name\": \"Nikesh\",\n" +
                "\t\"phone\":\"9812302612\"\n" +
                "     },\n" +
                "     {\n" +
                "\t\"name\": \"Nikesh\",\n" +
                "\t\"phone\":\"9812302612\"\n" +
                "     }\n" +
                "]";

        ListView listView=(ListView) findViewById(R.id.lv_contact);

        listView.setAdapter(new ArrayAdapter<Contact>(this,R.layout.row_contact_list, Contact.toList(data)){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

               if(convertView==null){
                   convertView=getLayoutInflater().inflate(R.layout.row_contact_list,null);
               }
                TextView tv_initial=(TextView)convertView.findViewById(R.id.tv_initial);
                TextView tv_fullname=(TextView)convertView.findViewById(R.id.tv_fullname);
                tv_initial.setText(getItem(position).name.toCharArray()[0]+"");
                tv_fullname.setText(getItem(position).name);

                return convertView;
            }
        });




    }



}
