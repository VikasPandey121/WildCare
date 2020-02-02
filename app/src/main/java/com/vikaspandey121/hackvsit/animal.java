package com.vikaspandey121.hackvsit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class animal extends AppCompatActivity {
    RecyclerView recycler_view;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        //Assign Variable
        recycler_view= findViewById(R.id.recycler_view);


        //Create Integer Array
        Integer[] langLogo = {R.drawable.ngo,R.drawable.ngoa, R.drawable.ngob,R.drawable.ngoc,R.drawable.ngod};


        //Create String Array
        String[] langName =  {"NGO 1","NGO 2","NGO 3","NGO 4","NGO 5"};

        //Initialize ArrayList
        mainModels = new ArrayList<>();
        for(int i=0;i<langLogo.length;i++)
        {
            MainModel model = new MainModel(langLogo[i],langName[i]);
            mainModels.add(model);
        }

        //Design Horizontal Layout

        LinearLayoutManager layoutManager =new LinearLayoutManager(
                animal.this,LinearLayoutManager.HORIZONTAL,false
        );

        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        //Initialize MainAdapter
        mainAdapter = new MainAdapter(animal.this,mainModels);

        recycler_view.setAdapter(mainAdapter);
    }
}
