package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class UpcomingPlanListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_plan_list);
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
                Intent ListViewMenuInt = new Intent(UpcomingPlanListActivity.this,ListViewActivity.class);
                startActivity(ListViewMenuInt);
                return true;

            case R.id.MyPlans_Menu:
                return true;

            case R.id.InputPlans_Menu:
                Intent InputPlansMenuInt = new Intent(UpcomingPlanListActivity.this,PlanInputActivity.class);
                startActivity(InputPlansMenuInt);
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(UpcomingPlanListActivity.this,LoginActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            default:
                return false;
        }
    }
}
