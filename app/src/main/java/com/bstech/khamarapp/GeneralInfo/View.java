package com.bstech.khamarapp.GeneralInfo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bstech.khamarapp.R;
import com.github.clans.fab.FloatingActionButton;

public class View extends AppCompatActivity {

    TextView tv_prag_milk, tv_prag_dry, tv_bokna, tv_sell_bachur, tv_new_child, tv_roughage, tv_granule,
            tv_total_milk, tv_krimi_nashok_applied, tv_inject_name, tv_krimi_nashok_not_applied,
            tv_infected_cow, tv_infected_bokna, tv_infected_bachur, tv_new_cow,
            tv_new_bokna, tv_new_bachur, tv_others;

    FloatingActionButton fav_edit_info;

    Typeface banglaFontFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info_saving_data_view);
        super.setTitle("জানুয়ারি, ২০১৯");

        initialization();
        clickActionHandler();
    }

    private void initialization(){
        tv_prag_milk = findViewById(R.id.tv_prag_milk);
        tv_prag_dry = findViewById(R.id.tv_prag_dry);
        tv_bokna = findViewById(R.id.tv_bokna);
        tv_sell_bachur = findViewById(R.id.tv_sell_bachur);
        tv_roughage = findViewById(R.id.tv_roughage);
        tv_new_child = findViewById(R.id.tv_new_child);
        tv_granule = findViewById(R.id.tv_granule);
        tv_total_milk = findViewById(R.id.tv_total_milk);
        tv_krimi_nashok_applied = findViewById(R.id.tv_krimi_nashok_applied);
        tv_inject_name = findViewById(R.id.tv_inject_name);
        tv_krimi_nashok_not_applied = findViewById(R.id.tv_krimi_nashok_not_applied);
        tv_infected_cow = findViewById(R.id.tv_infected_cow);
        tv_infected_bokna = findViewById(R.id.tv_infected_bokna);
        tv_infected_bachur = findViewById(R.id.tv_infected_bachur);
        tv_new_cow = findViewById(R.id.tv_new_cow);
        tv_new_bokna = findViewById(R.id.tv_new_bokna);
        tv_new_bachur = findViewById(R.id.tv_new_bachur);
        tv_others = findViewById(R.id.tv_others);

        fav_edit_info = findViewById(R.id.fav_edit_info);

        banglaFontFace = Typeface.createFromAsset(getAssets(), "fonts/KalpurushANSI.ttf");

        tv_prag_milk.setTypeface(banglaFontFace);
        tv_prag_dry.setTypeface(banglaFontFace);
        tv_bokna.setTypeface(banglaFontFace);
        tv_sell_bachur.setTypeface(banglaFontFace);
        tv_roughage.setTypeface(banglaFontFace);
        tv_new_child.setTypeface(banglaFontFace);
        tv_granule.setTypeface(banglaFontFace);
        tv_total_milk.setTypeface(banglaFontFace);
        tv_krimi_nashok_applied.setTypeface(banglaFontFace);
        tv_inject_name.setTypeface(banglaFontFace);
        tv_krimi_nashok_not_applied.setTypeface(banglaFontFace);
        tv_infected_cow.setTypeface(banglaFontFace);
        tv_infected_bokna.setTypeface(banglaFontFace);
        tv_infected_bachur.setTypeface(banglaFontFace);
        tv_new_cow.setTypeface(banglaFontFace);
        tv_new_bokna.setTypeface(banglaFontFace);
        tv_new_bachur.setTypeface(banglaFontFace);
    }

    private void clickActionHandler(){
        fav_edit_info.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(View.this, Form.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, YearMonth.class));
        finish();
    }
}
