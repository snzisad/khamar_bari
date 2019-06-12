package com.bstech.khamarapp.MilkInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bstech.khamarapp.HelperClasses.Adapter.CowSearchAdapter;
import com.bstech.khamarapp.HelperClasses.Adapter.MilkInfoAdapter;
import com.bstech.khamarapp.HelperClasses.Adapter.MilkInfoFormAdapter;
import com.bstech.khamarapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Form extends AppCompatActivity {

    RecyclerView rv_milk_cow_list;
    MilkInfoFormAdapter adapter;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_info_form);

        rv_milk_cow_list = findViewById(R.id.rv_milk_cow_list);

        data = new ArrayList<>();
        adapter = new MilkInfoFormAdapter(this, data);

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
}
