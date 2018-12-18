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

public class PlanInputActivity extends Activity implements View.OnClickListener {

    EditText editEventName, editEventDate, editEventLocation, editEventType, editEventDetails;
    Button buttonCreateEvent, buttonEventUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_input);

        buttonCreateEvent = findViewById(R.id.buttonCreateEvent);
        buttonEventUpdate = findViewById(R.id.buttonEventUpdate);
        editEventDate = findViewById(R.id.editEventDate);
        editEventName = findViewById(R.id.editEventName);
        editEventDetails = findViewById(R.id.editEventDetails);
        editEventType = findViewById(R.id.editEventType);
        editEventLocation = findViewById(R.id.editEventLocation);

        buttonCreateEvent.setOnClickListener(this);
        buttonEventUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Events");


        if (v == buttonCreateEvent) {
            String createName = editEventName.getText().toString();
            String createDate = editEventDate.getText().toString();
            String createDetails = editEventDetails.getText().toString();
            String createType = editEventType.getText().toString();
            String createLocation = editEventLocation.getText().toString();

            Event newEvent = new Event(createName, createDate, createLocation, createType, createDetails);


            myRef.push().setValue(newEvent);
        }
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
                Intent ListViewMenuInt = new Intent(PlanInputActivity.this,ListViewActivity.class);
                startActivity(ListViewMenuInt);
                return true;

            case R.id.MyPlans_Menu:
                Intent MyPlansMenuInt = new Intent(PlanInputActivity.this,UpcomingPlanListActivity.class);
                startActivity(MyPlansMenuInt);
                return true;

            case R.id.InputPlans_Menu:
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(PlanInputActivity.this,LoginActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            case R.id.Profile_Menu :
                Intent ProfileMenuInt = new Intent(PlanInputActivity .this,EditProfileActivity .class);
                startActivity(ProfileMenuInt );
                return true;

            default:
                return false;
        }
    }
}
