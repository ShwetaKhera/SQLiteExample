package com.project.shweta.shwetakherapractical;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<Profile> profileList = new ArrayList<>();
    private RecyclerView recyclerView ;
    private DataAdapter mdataAdapter;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbManager = new DBManager(getApplicationContext() );
        dbManager.open();

        recyclerView = findViewById(R.id.recyclerView);

        mdataAdapter = new DataAdapter(profileList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mdataAdapter);

        prepareProfileData();
    }

    private void prepareProfileData(){

        profileList.addAll(dbManager.getAllProfiles()) ;
        mdataAdapter.notifyDataSetChanged();
    }
}
