package com.bstech.khamarapp.ReproductionInfo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bstech.khamarapp.R;
import com.github.clans.fab.FloatingActionButton;

public class View extends AppCompatActivity {

    TextView tv_total_child, tv_last_delivery_date, tv_prag_detect, tv_next_delivery_date,
            tv_heat_date, tv_heat_time, tv_ai_date, tv_ai_time, tv_bull_id, tv_bull_species, tv_semean_production_date,
            tv_bachur_birth_weight, tv_bachur_gender, tv_repro_problem, tv_others;

    FloatingActionButton fav_re_ai, fav_edit_info;

    Typeface banglaFontFace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduction_info);
        super.setTitle("গাভী - #১");

        initialization();
        clickActionHandler();
    }


    private void initialization(){
        tv_total_child = findViewById(R.id.tv_total_child);
        tv_last_delivery_date = findViewById(R.id.tv_last_delivery_date);
        tv_prag_detect = findViewById(R.id.tv_prag_detect);
        tv_next_delivery_date = findViewById(R.id.tv_next_delivery_date);
        tv_heat_date = findViewById(R.id.tv_heat_date);
        tv_heat_time = findViewById(R.id.tv_heat_time);
        tv_ai_date = findViewById(R.id.tv_ai_date);
        tv_ai_time = findViewById(R.id.tv_ai_time);
        tv_bull_id = findViewById(R.id.tv_bull_id);
        tv_bull_species = findViewById(R.id.tv_bull_species);
        tv_semean_production_date = findViewById(R.id.tv_semean_production_date);
        tv_bachur_birth_weight = findViewById(R.id.tv_bachur_birth_weight);
        tv_bachur_gender = findViewById(R.id.tv_bachur_gender);
        tv_repro_problem = findViewById(R.id.tv_repro_problem);
        tv_others = findViewById(R.id.tv_others);

        fav_edit_info = findViewById(R.id.fav_edit_info);
        fav_re_ai = findViewById(R.id.fav_re_ai);

        banglaFontFace = Typeface.createFromAsset(getAssets(), "fonts/KalpurushANSI.ttf");

        tv_total_child.setTypeface(banglaFontFace);
        tv_last_delivery_date.setTypeface(banglaFontFace);
        tv_prag_detect.setTypeface(banglaFontFace);
        tv_next_delivery_date.setTypeface(banglaFontFace);
        tv_heat_date.setTypeface(banglaFontFace);
        tv_heat_time.setTypeface(banglaFontFace);
        tv_ai_date.setTypeface(banglaFontFace);
        tv_ai_time.setTypeface(banglaFontFace);
        tv_bull_id.setTypeface(banglaFontFace);
        tv_bull_species.setTypeface(banglaFontFace);
        tv_semean_production_date.setTypeface(banglaFontFace);
        tv_bachur_birth_weight.setTypeface(banglaFontFace);
        tv_bachur_gender.setTypeface(banglaFontFace);
    }


    private void clickActionHandler(){
        fav_edit_info.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(View.this, Form.class));
            }
        });

        fav_re_ai.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(View.this, AIForm.class));
            }
        });
    }
}
