package com.bstech.khamarapp.CowInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bstech.khamarapp.R;

public class Form extends AppCompatActivity {

    EditText edt_bdate;
    Spinner spn_species;
    ImageView img_cow_pic;
    Button btn_camera, btn_gallery, btn_done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_info_form);


        initialization();

        clickActionHandle();
    }

    private void initialization(){
        edt_bdate = findViewById(R.id.edt_bdate);
        spn_species = findViewById(R.id.spn_species);
        img_cow_pic = findViewById(R.id.img_cow_pic);
        btn_camera = findViewById(R.id.btn_camera);
        btn_gallery = findViewById(R.id.btn_gallery);
        btn_done = findViewById(R.id.btn_done);
    }

    private void clickActionHandle(){
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Form.this, "Coming Soon !!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Form.this, "Coming Soon !!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Form.this, "Coming Soon !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
