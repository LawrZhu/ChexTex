package com.chextex.chextex.chextex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {
    ListView listView;
    ArrayList<Contact> myContacts = new ArrayList<Contact>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        Contact testContact = new Contact("lawrence","911","address");
        myContacts.add(testContact);

        listView = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1,myContacts);

        listView.setAdapter(adapter);
    }
}
