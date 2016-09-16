package com.chextex.chextex.chextex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity {
    ListView listView;
    List<Contact> myContacts = new ArrayList<Contact>();
    ArrayAdapter<Contact> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        listView = (ListView) findViewById(R.id.listView);
        createFakeContacts();

        adapter = new contactListAdapter();
        listView.setAdapter(adapter);

    }

    //Tests to make fake contacts
    private void createFakeContacts() {
        myContacts.add(new Contact("lawrence","911","address"));
        myContacts.add(new Contact("michael","415","2nd address"));
    }

    private class contactListAdapter extends ArrayAdapter<Contact> {
        public contactListAdapter() {
            super(ContactList.this,R.layout.listview_item, myContacts);
        }

        @Override
        public View getView(int position,View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);
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
