package com.bstech.khamarapp.GeneralInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.bstech.khamarapp.MenuActivity;
import com.bstech.khamarapp.R;

public class YearMonth extends AppCompatActivity {

    Spinner spn_year, spn_month;
    Button btn_done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info_saving_year_select);

        initalization();
        clickActionHandler();
    }

    private void initalization(){
        spn_year = findViewById(R.id.spn_year);
        spn_month = findViewById(R.id.spn_month);
        btn_done = findViewById(R.id.btn_done);
    }

    private void clickActionHandler(){
        btn_done.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(YearMonth.this, View.class));
            }
        });
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
