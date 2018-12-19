package com.example.roywang.plans2nite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PlanPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);
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
                Intent ListViewMenuInt = new Intent(PlanPageActivity.this,ListViewActivity.class);
                startActivity(ListViewMenuInt);
                return true;

            case R.id.MyPlans_Menu:
                Intent MyPlansMenuInt = new Intent(PlanPageActivity.this,UpcomingPlanListActivity.class);
                startActivity(MyPlansMenuInt);
                return true;

            case R.id.InputPlans_Menu:
                Intent InputPlansMenuInt = new Intent(PlanPageActivity.this,PlanInputActivity.class);
                startActivity(InputPlansMenuInt);
                return true;

            case R.id.Profile_Menu :
                Intent ProfileMenuInt = new Intent(PlanPageActivity.this,ProfilePageActivity.class);
                startActivity(ProfileMenuInt );
                return true;

            case R.id.LogOut_Menu:
                Intent LogOutMenuInt = new Intent(PlanPageActivity.this,MainActivity.class);
                startActivity(LogOutMenuInt);
                return true;

            default:
                return false;
        }
    }

}

