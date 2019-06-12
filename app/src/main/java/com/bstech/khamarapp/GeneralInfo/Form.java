package com.bstech.khamarapp.GeneralInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bstech.khamarapp.R;

public class Form extends AppCompatActivity {

    EditText edt_prag_milk, edt_prag_dry, edt_bokna, edt_sell_bachur, edt_new_child, edt_roughage, edt_granule,
            edt_total_milk, edt_krimi_nashok_applied, edt_krimi_nashok_not_applied,
            edt_infected_cow, edt_infected_bokna, edt_infected_bachur, edt_new_cow,
            edt_new_bokna, edt_new_bachur, edt_others;

    Button btn_done_info;

    Spinner spn_inject_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info_saving_data_form);
        super.setTitle("জানুয়ারি, ২০১৯");

        initialization();
        clickActionHandler();
    }

    private void initialization(){
        edt_prag_milk = findViewById(R.id.edt_prag_milk);
        edt_prag_dry = findViewById(R.id.edt_prag_dry);
        edt_bokna = findViewById(R.id.edt_bokna);
        edt_sell_bachur = findViewById(R.id.edt_sell_bachur);
        edt_roughage = findViewById(R.id.edt_roughage);
        edt_new_child = findViewById(R.id.edt_new_child);
        edt_granule = findViewById(R.id.edt_granule);
        edt_total_milk = findViewById(R.id.edt_total_milk);
        edt_krimi_nashok_applied = findViewById(R.id.edt_krimi_nashok_applied);
        edt_krimi_nashok_not_applied = findViewById(R.id.edt_krimi_nashok_not_applied);
        edt_infected_cow = findViewById(R.id.edt_infected_cow);
        edt_infected_bokna = findViewById(R.id.edt_infected_bokna);
        edt_infected_bachur = findViewById(R.id.edt_infected_bachur);
        edt_new_cow = findViewById(R.id.edt_new_cow);
        edt_new_bokna = findViewById(R.id.edt_new_bokna);
        edt_new_bachur = findViewById(R.id.edt_new_bachur);
        edt_others = findViewById(R.id.edt_others);

        btn_done_info = findViewById(R.id.btn_done_info);
        spn_inject_name = findViewById(R.id.spn_inject_name);

    }

    private void clickActionHandler(){
        btn_done_info.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Toast.makeText(Form.this, "তথ্য সফলভাবে পরিবর্তন হয়েছে", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Form.this, View.class));
                finish();
            }
        });
    }

}
