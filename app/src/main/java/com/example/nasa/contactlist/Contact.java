package com.example.nasa.contactlist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NASA on 2/25/2018.
 */

public class Contact {

    public String name,phone;

    public Contact(){

    }

    public Contact(JSONObject jsonObject){
       this.name=jsonObject.optString("name");
       this.phone=jsonObject.optString("phone");
    }

    public static List<Contact> toList(String data){

        List<Contact> contactList = new ArrayList<>();

        try {
            JSONArray jsonArray =new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject contactJSON = jsonArray.optJSONObject(i);
                Contact contact = new Contact(contactJSON);
                contactList.add(contact);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contactList;

    }


}
