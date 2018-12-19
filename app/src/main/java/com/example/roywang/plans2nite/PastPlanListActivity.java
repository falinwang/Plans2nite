package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PastPlanListActivity extends Activity implements View.OnClickListener {

    Button buttonSwitchUpcoming, buttonSwitchPast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_plan_list);

        buttonSwitchPast = findViewById(R.id.buttonSwitchPast);
        buttonSwitchUpcoming = findViewById(R.id.buttonSwitchUpcoming);

        buttonSwitchPast.setOnClickListener(this);
        buttonSwitchUpcoming.setOnClickListener(this);

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
                Intent ListViewMenuInt = new Intent(PastPlanListActivity.this,ListViewActivity.class);
                startActivity(ListViewMenuInt);
                return true;

            case R.id.MyPlans_Menu:
                Intent MyPlansMenuInt = new Intent(PastPlanListActivity.this,PastPlanListActivity.class);
                startActivity(MyPlansMenuInt);
                return true;

            case R.id.InputPlans_Menu:
                Intent InputPlansMenuInt = new Intent(PastPlanListActivity.this,PlanInputActivity.class);
                startActivity(InputPlansMenuInt);
                return true;

            case R.id.Profile_Menu :
                Intent ProfileMenuInt = new Intent(PastPlanListActivity.this,ProfilePageActivity.class);
                startActivity(ProfileMenuInt );
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(PastPlanListActivity.this,MainActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSwitchPast){


        } else if (v == buttonSwitchUpcoming) {
            Intent SwitchUpcomingEvent = new Intent(PastPlanListActivity.this, UpcomingPlanListActivity.class);
            startActivity(SwitchUpcomingEvent);
        }
    }
}
