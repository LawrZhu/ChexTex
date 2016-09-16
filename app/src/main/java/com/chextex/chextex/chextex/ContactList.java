package com.chextex.chextex.chextex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity {
    protected ListView listView;
    protected List<Contact> myContacts = new ArrayList<>();
    protected ArrayAdapter<Contact> adapter;
    protected String name;
    protected String phoneNumber;
    protected String address;
    protected int contactIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO: LAWRENCE ADD YOUR CODE HERE

                Toast.makeText(ContactList.this, "I HAVE A SMALL PENIS",
                        Toast.LENGTH_SHORT).show();
                Log.d("M","SMALLPENIS");
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent boobies = new Intent(ContactList.this, EditUser.class);
                startActivity(boobies);
                return true;
            }
        });


        createFakeContacts();
        adapter = new contactListAdapter();
        listView.setAdapter(adapter);

    }

    //Tests to make fake contacts
    private void createFakeContacts() {
        myContacts.add(new Contact("Lawrence","000-000-0000","548 Market St, San Francisco, CA 94104"));
        myContacts.add(new Contact("Michael","123-456-7890","1 Grand Ave, San Luis Obispo, CA 93405"));
    }

    public void createNewContact(){

    }

    private class contactListAdapter extends ArrayAdapter<Contact> {
        public contactListAdapter() {
            super(ContactList.this,R.layout.listview_item, myContacts);
        }

        @Override
        public View getView(int position,View view, ViewGroup parent) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);
            }

            Contact cur = myContacts.get(position);
            TextView name = (TextView) view.findViewById(R.id.contact_name);
            name.setText(cur.getName());
            TextView address = (TextView) view.findViewById(R.id.contact_address);
            address.setText(cur.getAddress());
            TextView phone = (TextView) view.findViewById(R.id.contact_number);
            phone.setText(cur.getPhoneNumber());

            return view;
        }
    }
}
