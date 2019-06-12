package com.bstech.khamarapp.ReproductionInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bstech.khamarapp.HelperClasses.Adapter.ReproductionInfoAdapter;
import com.bstech.khamarapp.R;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class List extends AppCompatActivity {
    RecyclerView rv_reproduction_info;
    Toolbar toolbar_reproduction_info;
    ImageView img_cow_pic;
    FloatingActionButton fav_add_info;
    ArrayList<HashMap<String, String>> items;
    ReproductionInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduction_info_list);


        intialization();
        clickActionHandler();

    }


    private void intialization(){
        toolbar_reproduction_info =  findViewById(R.id.toolbar_reproduction_info);
        img_cow_pic =  findViewById(R.id.img_cow_pic);
        fav_add_info =  findViewById(R.id.fav_add_info);
        rv_reproduction_info =  findViewById(R.id.rv_reproduction_info);

        items = new ArrayList<>();

        adapter = new ReproductionInfoAdapter(this, items);

        rv_reproduction_info.setAdapter(adapter);
        rv_reproduction_info.setLayoutManager(new LinearLayoutManager(this));

        HashMap<String, String> item = new HashMap<>();
        item.put("id", "9");
        item.put("heat_date", "12-05-2019");
        item.put("next_delivery_date", "13-05-2019");
        item.put("last_delivery_date", "20-02-2019");

        items.add(item);

        item = new HashMap<>();
        item.put("id", "99");
        item.put("heat_date", "12-07-2019");
        item.put("next_delivery_date", "13-09-2019");
        item.put("last_delivery_date", "20-05-2019");

        items.add(item);

        item = new HashMap<>();
        item.put("id", "99");
        item.put("heat_date", "12-07-2019");
        item.put("next_delivery_date", "13-09-2019");
        item.put("last_delivery_date", "20-05-2019");

        items.add(item);

        item = new HashMap<>();
        item.put("id", "99");
        item.put("heat_date", "12-07-2019");
        item.put("next_delivery_date", "13-09-2019");
        item.put("last_delivery_date", "20-05-2019");

        items.add(item);

        item = new HashMap<>();
        item.put("id", "99");
        item.put("heat_date", "12-07-2019");
        item.put("next_delivery_date", "13-09-2019");
        item.put("last_delivery_date", "20-05-2019");

        items.add(item);

        item = new HashMap<>();
        item.put("id", "999");
        item.put("heat_date", "12-05-2019");
        item.put("next_delivery_date", "13-05-2019");
        item.put("last_delivery_date", "20-02-2019");


        items.add(item);


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
