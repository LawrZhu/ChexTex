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

        listView = (ListView)findViewById(R.id.listView);

    }

    private void createFakeContacts() {
        Contact testContact = new Contact("lawrence","911","address");
        Contact testContact2 = new Contact("michael","415","2nd address");
        myContacts.add(testContact);
        myContacts.add(testContact2);
    }

    private class contactListAdapter extends ArrayAdapter<Contact> {
        public contactListAdapter() {
            super(ContactList.this,R.layout.activity_contact_list, myContacts);
        }
    }
}
