package com.capstoneproject.elie_emile;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.capstoneproject.elie_emile.R;

import java.util.ArrayList;


public class elie_emile_DishActivity extends AppCompatActivity {
    private RecyclerView recyclerView,cuisine_list;
    private ArrayList<elie_emile_Restaurant>restaurants;
    private ArrayList<elie_emile_Cuisine>cuisines;
    private elie_emile_DishAdapter dishAdapter;
    private elie_emile_OrderAdapter DishAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swiperefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elie_emile_dish_activity);
        recyclerView = findViewById(R.id.restaurant_list);
        cuisine_list = findViewById(R.id.cuisine_list);
        swiperefresh = findViewById(R.id.swiperefresh);

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
            }
        });

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initViews();
    }
    private void pojoData(){
        Bundle extras = getIntent().getExtras();
        int restaurant_id;
        if (extras != null) {
            restaurant_id = extras.getInt("restaurant_id");
        }else{
            finish();
            return;
        }


        restaurants = new ArrayList<>();
        cuisines = new ArrayList<>();
        if(restaurant_id == 0) {
            restaurants.add(new elie_emile_Restaurant(1, "Rwanda Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/146.jpg"));
            restaurants.add(new elie_emile_Restaurant(2, "Burundian Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/145.jpg"));
            restaurants.add(new elie_emile_Restaurant(3, "Kenyan Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/144.jpg"));
            restaurants.add(new elie_emile_Restaurant(4, "Tanzanian Dish", "Fresh african,american,Asia Dishes", "https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png"));
        }else if(restaurant_id == 1) {
            restaurants.add(new elie_emile_Restaurant(1, "Mexican Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/156.jpg"));
            restaurants.add(new elie_emile_Restaurant(2, "European Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/155.jpg"));
            restaurants.add(new elie_emile_Restaurant(3, "Indian Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/154.jpg"));
            restaurants.add(new elie_emile_Restaurant(4, "Congo Dish", "Fresh african,american,Asia Dishes", "https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png"));
        }else if(restaurant_id == 2) {
            restaurants.add(new elie_emile_Restaurant(1, "Iran Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/106.jpg"));
            restaurants.add(new elie_emile_Restaurant(2, "SouthAfrica Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/105.jpg"));
            restaurants.add(new elie_emile_Restaurant(3, "France Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/104.jpg"));
            restaurants.add(new elie_emile_Restaurant(4, "Madagascar Dish", "Fresh african,american,Asia Dishes", "https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png"));
        }else if(restaurant_id == 3) {
            restaurants.add(new elie_emile_Restaurant(1, "Egyptian Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/146.jpg"));
            restaurants.add(new elie_emile_Restaurant(2, "Tongo Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/145.jpg"));
            restaurants.add(new elie_emile_Restaurant(3, "German Dish", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/144.jpg"));
            restaurants.add(new elie_emile_Restaurant(4, "Ukraine Dish", "Fresh african,american,Asia Dishes", "https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png"));
        }else {
            restaurants.add(new elie_emile_Restaurant(1, "Dish 1", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/166.jpg"));
            restaurants.add(new elie_emile_Restaurant(2, "Dish 2", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/155.jpg"));
            restaurants.add(new elie_emile_Restaurant(3, "Dish 3", "Fresh african,american,Asia Dishes", "https://www.delonghi.com/Global/recipes/multifry/164.jpg"));
            restaurants.add(new elie_emile_Restaurant(4, "Dish 4", "Fresh african,american,Asia Dishes", "https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png"));
        }

        cuisines.add(new elie_emile_Cuisine(1,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/134.jpg","5,000 Frw","Rice African"));
        cuisines.add(new elie_emile_Cuisine(2,1,"Chicken Fry","https://www.delonghi.com/Global/recipes/multifry/135.jpg","5,000 Frw","Rice African"));
        cuisines.add(new elie_emile_Cuisine(3,1,"Beans","https://www.delonghi.com/Global/recipes/multifry/136.jpg","5,000 Frw","Rice African"));
        cuisines.add(new elie_emile_Cuisine(4,1,"Boilo","https://www.delonghi.com/Global/recipes/multifry/137.jpg","5,000 Frw","Rice African"));
    }
    private void initViews(){
        pojoData();
        dishAdapter = new elie_emile_DishAdapter(elie_emile_DishActivity.this,restaurants);
        DishAdapter = new elie_emile_OrderAdapter(elie_emile_DishActivity.this,cuisines);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dishAdapter);
        LinearLayoutManager lManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cuisine_list.setLayoutManager(lManager);
        cuisine_list.setAdapter(DishAdapter);
        if(swiperefresh.isRefreshing()){
            swiperefresh.setRefreshing(false);
        }
    }
}