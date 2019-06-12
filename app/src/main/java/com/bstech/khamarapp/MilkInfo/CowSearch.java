package com.bstech.khamarapp.MilkInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bstech.khamarapp.HelperClasses.Adapter.CowAdapter;
import com.bstech.khamarapp.HelperClasses.Adapter.CowSearchAdapter;
import com.bstech.khamarapp.HelperClasses.Model.CowModel;
import com.bstech.khamarapp.MenuActivity;
import com.bstech.khamarapp.R;

import java.util.ArrayList;

public class CowSearch extends AppCompatActivity {
    RecyclerView rv_cow_list;
    CowSearchAdapter adapter;
    ArrayList<CowModel> cowlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_search);

        rv_cow_list = findViewById(R.id.rv_cow_list);

        cowlist = new ArrayList<>();
        adapter = new CowSearchAdapter(this, cowlist);

        rv_cow_list.setAdapter(adapter);
        rv_cow_list.setLayoutManager(new LinearLayoutManager(this));

        cowlist.add(new CowModel(1, "asdsad", "Mixed", "03-02-2001"));

        cowlist.add(new CowModel(2, "qwqe", "Jersey", "23-05-2018"));

        cowlist.add(new CowModel(3, "qweqwe", "Hariana", "03-02-2019"));


        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.menu_search);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
            }
        });

        return true;
    }



}
