package com.example.destinasiwisatabali;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Klungkung extends AppCompatActivity {
    String tittle = "Klungkung";
    private RecyclerView rvCategory;
    private ArrayList<Wisata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klungkung);
        rvCategory = findViewById(R.id.Klungkung);
        rvCategory.setHasFixedSize(true);

        setActionBarTittle(tittle);

        list.addAll(KlungkungData.getListData());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        showRecyclerList();
    }
    private void setActionBarTittle(String tittle) {
        getSupportActionBar().setTitle(tittle);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListKabupatenAdapter listKabupatenAdapter = new ListKabupatenAdapter(this);
        listKabupatenAdapter.setListWisata(list);
        rvCategory.setAdapter(listKabupatenAdapter);
    }
}