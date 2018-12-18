package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfilePageActivity extends Activity implements View.OnClickListener{

    TextView textViewName1,textViewGender1,textViewAddress1,textViewEmail1,textViewContact1;
    Button buttonEditProfile, buttonLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        textViewAddress1=findViewById(R.id.textViewAddress1 ) ;
        textViewName1 =findViewById(R.id.textViewName1  ) ;
        textViewGender1 =findViewById(R.id.textViewGender1  ) ;
        textViewEmail1 =findViewById(R.id.textViewEmail1  ) ;
        textViewContact1 =findViewById(R.id.textViewContact1  ) ;

        buttonEditProfile =findViewById(R.id.buttonEditProfile );
        buttonLogout = findViewById(R.id.buttonLogout ) ;

        buttonEditProfile.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);

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
                Intent ListViewMenuInt = new Intent(ProfilePageActivity .this, ListViewActivity.class);
                startActivity(ListViewMenuInt);
                return true;

            case R.id.MyPlans_Menu:
                Intent MyPlansMenuInt = new Intent(ProfilePageActivity .this, UpcomingPlanListActivity.class);
                startActivity(MyPlansMenuInt);
                return true;

            case R.id.InputPlans_Menu:
                Intent InputPlanInt = new Intent(ProfilePageActivity .this, PlanInputActivity.class);
                startActivity(InputPlanInt);
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(ProfilePageActivity .this, LoginActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            case R.id.Profile_Menu:
                Intent ProfilePageInt = new Intent(ProfilePageActivity .this, EditProfileActivity .class);
                startActivity(ProfilePageInt );
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");
        String usercurrent=mAuth.getCurrentUser().getEmail();
        myRef.orderByChild("email").equalTo(usercurrent).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                User findUser=dataSnapshot.getValue(User.class);
                String useremail=mAuth.getCurrentUser().getEmail();
                textViewAddress1.setText(findUser.location );
                textViewContact1.setText(findUser.contact );
                textViewEmail1.setText(useremail );
                textViewGender1.setText(findUser.gender );
                textViewName1.setText(findUser.name );

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(v==buttonEditProfile )
        {
            Intent editProfileInt=new Intent(ProfilePageActivity.this,EditProfileActivity.class);
            startActivity(editProfileInt );

        }
        if(v==buttonLogout)
        {
            Intent logoutInt=new Intent(ProfilePageActivity.this,LoginActivity .class);
            startActivity(logoutInt );

        }


    }
}
