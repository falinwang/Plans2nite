package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Hello this is a test

public class EditProfileActivity extends Activity implements View.OnClickListener {

    EditText editTextName1,editTextLocation1,editTextGender1 ,editTextContact1;
    Button buttonSave,buttonViewProfile;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextContact1 =findViewById(R.id.editTextContact1) ;
        editTextGender1= findViewById(R.id.editTextGender1   );
        editTextLocation1=findViewById(R.id.editTextLocation1 ) ;
        editTextName1=findViewById(R.id.editTextName1 );

        buttonSave=findViewById(R.id.buttonSave ) ;
        buttonViewProfile= findViewById(R.id.buttonViewProfile ) ;

        buttonSave.setOnClickListener(this);
        buttonViewProfile.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


        }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater optionsMenuInflater = getMenuInflater();
        optionsMenuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ListView_Menu:
                Intent ListViewMenuInt = new Intent(EditProfileActivity .this,ListViewActivity.class);
                startActivity(ListViewMenuInt);
                return true;

            case R.id.MyPlans_Menu:
                Intent MyPlansMenuInt = new Intent(EditProfileActivity .this,UpcomingPlanListActivity.class);
                startActivity(MyPlansMenuInt);
                return true;

            case R.id.InputPlans_Menu:
                Intent InputPlanInt = new Intent(EditProfileActivity .this,PlanInputActivity .class);
                startActivity(InputPlanInt);
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(EditProfileActivity .this,LoginActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            case R.id.Profile_Menu :
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        if(v==buttonSave )

        {
            String createName=editTextName1.getText().toString();
            String createEmail=mAuth.getCurrentUser().getEmail() ;
            String createLocation=editTextLocation1.getText().toString();
            String createContact=editTextContact1.getText().toString();
            String createGender=editTextGender1.getText().toString();

            User newUser=new User(createName,createLocation,createEmail ,createContact,createGender  );

            myRef.push().setValue(newUser);

            }

            if(v==buttonViewProfile)
            {
Intent ProfileIntent=new Intent(EditProfileActivity.this,ProfilePageActivity.class);
startActivity(ProfileIntent );
            }

    }
}
