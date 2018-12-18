package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListViewActivity extends Activity {

    private ArrayList<Event> events;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        events = new ArrayList<>();
        initRecyclerView();
        getEvents();
    }

    private void getEvents() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventsRef = database.getReference("events");

        eventsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Toast.makeText(ListViewActivity.this, "datasnapshot", Toast.LENGTH_SHORT).show();

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    Event event = child.getValue(Event.class);
                    events.add(event);
                }
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(events, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
                return true;

            case R.id.MyPlans_Menu:
                Intent MyPlansMenuInt = new Intent(ListViewActivity.this,UpcomingPlanListActivity.class);
                startActivity(MyPlansMenuInt);
                return true;

            case R.id.InputPlans_Menu:
                Intent InputPlansMenuInt = new Intent(ListViewActivity.this,PlanInputActivity.class);
                startActivity(InputPlansMenuInt);
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(ListViewActivity.this,LoginActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            case R.id.Profile_Menu :
                Intent ProfileMenuInt = new Intent(ListViewActivity.this,EditProfileActivity .class);
                startActivity(ProfileMenuInt );
                return true;

            default:
                return false;
        }
    }
}
