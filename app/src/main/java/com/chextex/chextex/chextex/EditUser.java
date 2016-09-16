package com.chextex.chextex.chextex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUser extends AppCompatActivity {

    protected Button confirm;
    protected Bundle bundle;
    protected String name;
    protected String phoneNumber;
    protected String address;
    protected int contactIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        bundle = getIntent().getExtras();
        name = bundle.getString("name");
        phoneNumber = bundle.getString("phoneNumber");
        address = bundle.getString("address");
        contactIndex = bundle.getInt("index");

        EditText n = (EditText)findViewById(R.id.name);
        EditText pa = (EditText)findViewById(R.id.postalAddress);
        EditText pn = (EditText)findViewById(R.id.phoneNumber);
        n.setText(name);
        pn.setText(phoneNumber);
        pa.setText(address);

        confirm = (Button)findViewById(R.id.confirm);

        //When confirm button is clicked
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditUser.this, ContactList.class);

                bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("address", address);
                bundle.putString("phoneNumber", phoneNumber);
                bundle.putInt("index", contactIndex);

                i.putExtras(bundle);

                startActivity(i);
            }
        });
    }
}
