package com.vikaspandey121.hackvsit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class game extends AppCompatActivity {

    //Initialize Variable

    RecyclerView recycler_view;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Assign Variable
        recycler_view= findViewById(R.id.recycler_view);


        //Create Integer Array
        Integer[] langLogo = {R.drawable.tiger,R.drawable.indian_bull, R.drawable.leopard,R.drawable.lion,R.drawable.red_panda,R.drawable.rhino,R.drawable.hagul,};


        //Create String Array
        String[] langName =  {"Bengal Tiger","Indian Bull","Leopard","Lion","Red Panda","Rhino","Hangul"};

        //Initialize ArrayList
        mainModels = new ArrayList<>();
        for(int i=0;i<langLogo.length;i++)
        {
           MainModel model = new MainModel(langLogo[i],langName[i]);
           mainModels.add(model);
        }

        //Design Horizontal Layout

        LinearLayoutManager layoutManager =new LinearLayoutManager(
                game.this,LinearLayoutManager.HORIZONTAL,false
        );

        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        //Initialize MainAdapter
        mainAdapter = new MainAdapter(game.this,mainModels);

        recycler_view.setAdapter(mainAdapter);
    }
}
