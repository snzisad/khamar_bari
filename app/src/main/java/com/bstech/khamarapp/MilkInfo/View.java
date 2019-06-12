package com.bstech.khamarapp.MilkInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bstech.khamarapp.HelperClasses.Adapter.MilkInfoAdapter;
import com.bstech.khamarapp.R;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class View extends AppCompatActivity {

    RecyclerView rv_milk_cow_list;
    FloatingActionButton fav_edit_info, fav_add_info;
    MilkInfoAdapter adapter;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_info_view);
        setTitle(R.string.menu3_bn);

        intialization();

        clickActionHandler();
    }

    private void intialization(){
        rv_milk_cow_list = findViewById(R.id.rv_milk_cow_list);
        fav_edit_info = findViewById(R.id.fav_edit_info);
        fav_add_info = findViewById(R.id.fav_add_info);

        data = new ArrayList<>();
        adapter = new MilkInfoAdapter(this, data);

        rv_milk_cow_list.setAdapter(adapter);
        rv_milk_cow_list.setLayoutManager(new LinearLayoutManager(this));

        content = new HashMap<>();
        content.put("id", "1");
        content.put("amount", "50");
        data.add(content);

        content = new HashMap<>();
        content.put("id", "99");
        content.put("amount", "10");
        data.add(content);

        content = new HashMap<>();
        content.put("id", "999");
        content.put("amount", "550");
        data.add(content);

        content = new HashMap<>();
        content.put("id", "9999");
        content.put("amount", "95");
        data.add(content);

        adapter.notifyDataSetChanged();

    }

    private void clickActionHandler(){
        fav_add_info.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(View.this, CowSearch.class));
            }
        });

        fav_edit_info.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(View.this, Form.class));
            }
        });
    }
}
