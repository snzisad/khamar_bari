package com.bstech.khamarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bstech.khamarapp.CowInfo.List;
import com.bstech.khamarapp.GeneralInfo.YearMonth;

public class MenuActivity extends AppCompatActivity {

    CardView cv_general_info_saving_button, cv_cow_info_saving_button, cv_milk_info_saving_button,
            cv_report_button, cv_alarm_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initialization();
        clickActionHandler();
    }

    private void initialization(){
        //this function will initialize all global variables

        cv_general_info_saving_button = findViewById(R.id.cv_general_info_saving_button);
        cv_cow_info_saving_button = findViewById(R.id.cv_cow_info_saving_button);
        cv_milk_info_saving_button = findViewById(R.id.cv_milk_info_saving_button);
        cv_report_button = findViewById(R.id.cv_report_button);
        cv_alarm_button = findViewById(R.id.cv_alarm_button);
    }

    private void clickActionHandler(){
        //this function will handle all click action

        cv_general_info_saving_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, YearMonth.class));
            }
        });
        cv_cow_info_saving_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, List.class));
            }
        });
        cv_milk_info_saving_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, com.bstech.khamarapp.MilkInfo.View.class));
            }
        });
        cv_report_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Coming Soon !!", Toast.LENGTH_SHORT).show();
            }
        });
        cv_alarm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Coming Soon !!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuID = item.getItemId();

        switch (menuID){
            case R.id.menu_about:
                Toast.makeText(MenuActivity.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(MenuActivity.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }


        return true;
    }


    @Override
    public void onBackPressed() {
//        moveTaskToBack(true);
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

        finish();

    }
}
