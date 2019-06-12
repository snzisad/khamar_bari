package com.bstech.khamarapp.ReproductionInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bstech.khamarapp.R;

public class Form extends AppCompatActivity {

    EditText edt_total_baby, edt_last_delivery_date, edt_prag_detect, edt_next_delivery_date, edt_heat_date, edt_heat_time, edt_ai_date, edt_ai_time,
            edt_bull_id, edt_bull_species, edt_semean_produce_date, edt_bachur_birth_weight, edt_repro_problem, edt_others;

    Spinner spn_bachur_gender;

    Button btn_done_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduction_info_form);
        setTitle("প্রজনন কার্যক্রম তথ্য সংরক্ষণ");

        initialization();
        clickActionHandler();

    }

    private void initialization(){
        edt_total_baby = findViewById(R.id.edt_total_baby);
        edt_last_delivery_date = findViewById(R.id.edt_last_delivery_date);
        edt_prag_detect = findViewById(R.id.edt_prag_detect);
        edt_next_delivery_date = findViewById(R.id.edt_next_delivery_date);
        edt_heat_date = findViewById(R.id.edt_heat_date);
        edt_heat_time = findViewById(R.id.edt_heat_time);
        edt_ai_date = findViewById(R.id.edt_ai_date);
        edt_ai_time = findViewById(R.id.edt_ai_time);
        edt_bull_id = findViewById(R.id.edt_bull_id);
        edt_bull_species = findViewById(R.id.edt_bull_species);
        edt_semean_produce_date = findViewById(R.id.edt_semean_produce_date);
        edt_bachur_birth_weight = findViewById(R.id.edt_bachur_birth_weight);
        edt_repro_problem = findViewById(R.id.edt_repro_problem);
        edt_others = findViewById(R.id.edt_others);
        spn_bachur_gender = findViewById(R.id.spn_bachur_gender);
        btn_done_info = findViewById(R.id.btn_done_info);
    }

    private void clickActionHandler(){
        btn_done_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Form.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
