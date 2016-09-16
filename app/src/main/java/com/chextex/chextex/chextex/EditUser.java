package com.chextex.chextex.chextex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditUser extends AppCompatActivity {

    protected Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        confirm = (Button)findViewById(R.id.confirm);

        //When confirm button is clicked
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditUser.this, ContactList.class));
            }
        });
    }
}
