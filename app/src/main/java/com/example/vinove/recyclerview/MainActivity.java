package com.example.vinove.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;


    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String[] languages;
    LinearLayoutManager linearLayoutManager;

    ArrayList<String[]> al = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fab = findViewById(R.id.fab_btn)

        final RecyclerView programmingList = findViewById(R.id.programmingList);

        linearLayoutManager = new LinearLayoutManager(this);

        languages = new String[]{"Java", "JavaScript", "Android", "Ruby", "Swift4", "R", "Python", "PHP", "C", "C++"};
        al.add(languages);
        programmingList.setAdapter(new ProgrammingAdapter(languages));
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        programmingList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {


                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                currentItems = linearLayoutManager.getChildCount();
                totalItems = linearLayoutManager.getItemCount();
                scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();


                if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                    isScrolling = false;
                }


            }
        });
    }


    public void fabBtn(View view) {

        Toast.makeText(getApplicationContext(), "Floating Action Button", Toast.LENGTH_SHORT).show();

    }

}

