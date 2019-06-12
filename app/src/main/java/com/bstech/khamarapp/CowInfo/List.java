package com.bstech.khamarapp.CowInfo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bstech.khamarapp.HelperClasses.Adapter.CowAdapter;
import com.bstech.khamarapp.HelperClasses.Model.CowModel;
import com.bstech.khamarapp.R;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    RecyclerView rlv_cow_data_list;
    CowAdapter adapter;
    ArrayList<CowModel> cowlist;
    FloatingActionButton fav_add_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_info_list);

        initialization();

        clickActionHandler();


    }

    private void initialization(){
        fav_add_info = findViewById(R.id.fav_add_info);
        rlv_cow_data_list = findViewById(R.id.rlv_cow_data_list);

        cowlist = new ArrayList<>();
        adapter = new CowAdapter(this, cowlist);

        rlv_cow_data_list.setAdapter(adapter);
        rlv_cow_data_list.setLayoutManager(new LinearLayoutManager(this));

        cowlist.add(new CowModel(1, "asdsad", "Mixed", "03-02-2001"));

        cowlist.add(new CowModel(2, "qwqe", "Jersey", "23-05-2018"));

        cowlist.add(new CowModel(3, "qweqwe", "Hariana", "03-02-2019"));


        adapter.notifyDataSetChanged();

    }

    private void clickActionHandler(){
        fav_add_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(List.this, Form.class));
            }
        });
    }
}
