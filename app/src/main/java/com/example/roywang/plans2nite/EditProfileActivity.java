package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Hello this is a test

public class EditProfileActivity extends Activity implements View.OnClickListener {

    EditText editTextName1,editTextLocation1,editTextEmail1,editTextContact1;
    Button buttonSave,buttonViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextContact1 =findViewById(R.id.editTextContact1) ;
        editTextEmail1= findViewById(R.id.editTextEmail1  );
        editTextLocation1=findViewById(R.id.editTextLocation1 ) ;
        editTextName1=findViewById(R.id.editTextName1 );

        buttonSave=findViewById(R.id.buttonSave ) ;
        buttonViewProfile= findViewById(R.id.buttonViewProfile ) ;

        buttonSave.setOnClickListener(this);
        buttonViewProfile.setOnClickListener(this);




        }

    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        if(v==buttonSave )

        {
            String createName=editTextName1.getText().toString();
            String createEmail=editTextEmail1.getText().toString();
            String createLocation=editTextLocation1.getText().toString();
            String createContact=editTextContact1.getText().toString();

            User newUser=new User(createName,createLocation,createEmail ,createContact );

            myRef.push().setValue(newUser);

            }

            if(v==buttonViewProfile)
            {
Intent ProfileIntent=new Intent(EditProfileActivity.this,ProfilePageActivity.class);
startActivity(ProfileIntent );
            }

    }
}
