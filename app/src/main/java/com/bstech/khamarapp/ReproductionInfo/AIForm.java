package com.bstech.khamarapp.ReproductionInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bstech.khamarapp.R;

public class AIForm extends AppCompatActivity {

    EditText edt_prag_detect, edt_ai_date, edt_ai_time, edt_bull_id, edt_bull_species, edt_semean_produce_date;

    Button btn_done_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduction_info_aiform);
        setTitle("পুনরায় এআই");

        initialization();
        clickActionHandler();
    }

    private void initialization(){
        edt_prag_detect = findViewById(R.id.edt_prag_detect);
        edt_ai_date = findViewById(R.id.edt_ai_date);
        edt_ai_time = findViewById(R.id.edt_ai_time);
        edt_bull_id = findViewById(R.id.edt_bull_id);
        edt_bull_species = findViewById(R.id.edt_bull_species);
        edt_semean_produce_date = findViewById(R.id.edt_semean_produce_date);

        btn_done_info = findViewById(R.id.btn_done_info);
    }

    private void clickActionHandler(){
        btn_done_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AIForm.this, "Coming Soon !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
