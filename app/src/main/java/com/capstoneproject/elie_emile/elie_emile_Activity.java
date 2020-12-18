package com.capstoneproject.elie_emile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.capstoneproject.elie_emile.R;

import java.util.ArrayList;

public class elie_emile_Activity extends AppCompatActivity {
    private RecyclerView recyclerView,cuisine_list;
    private ArrayList<elie_emile_Restaurant>restaurants;
    private ArrayList<elie_emile_Cuisine>cuisines;
    private elie_emile_RestaurantAdapter restaurantAdapter;
    private elie_emile_OrderAdapter cuisineAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swiperefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elie_emile_activity_main);
        recyclerView = findViewById(R.id.restaurant_list);
        cuisine_list = findViewById(R.id.cuisine_list);
        swiperefresh = findViewById(R.id.swiperefresh);

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
            }
        });
        initViews();
    }
    private void pojoData(){
        restaurants = new ArrayList<>();
        cuisines = new ArrayList<>();
        restaurants.add(new elie_emile_Restaurant(1,"Chez Rando","Riders Lounge, Kigali: See 26 unbiased reviews of Riders Lounge, rated 3 of 5 on Tripadvisor and ranked #184 of 208 restaurants in Kigali.","https://img.theculturetrip.com/768x/smart/wp-content/uploads/2017/09/screen-shot-2017-09-23-at-5-01-15-pm.png"));
        restaurants.add(new elie_emile_Restaurant(2,"The Bistro mu gikali","There aren't enough food, service, value or atmosphere ratings for Java House Kigali Heights, Rwanda yet. Be one of the first to write a review! Write a Review ...","https://img.theculturetrip.com/768x/smart/wp-content/uploads/2017/09/screen-shot-2017-09-01-at-4-12-55-pm.png"));
        restaurants.add(new elie_emile_Restaurant(3,"Repub Restaurent","29 Sept 2017 — Over the last few years, residents have witnessed the restaurant scene boom in Kigali. The city has embraced its status as a bourgeoning ...","https://img.theculturetrip.com/768x/smart/wp-content/uploads/2017/08/img_8890.jpg"));
        restaurants.add(new elie_emile_Restaurant(3,"Blue Hotel","Kaze's Kitchen, Kigali, Rwanda. 54 likes. We offer home cooked meals and delivery from breakfast servings, delicious pies & cakes and we offer different...","https://images.squarespace-cdn.com/content/v1/5ea07d86ae504a7e585fd795/1599411312174-QBM9FMB2GEPXIN77SR6I/ke17ZwdGBToddI8pDm48kDHPSfPanjkWqhH6pl6g5ph7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mwONMR1ELp49Lyc52iWr5dNb1QJw9casjKdtTg1_-y4jz4ptJBmI9gQmbjSQnNGng/Ikaze+Muri+Kigali+Convention+Centre?format=500w"));

        cuisines.add(new elie_emile_Cuisine(1,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
        cuisines.add(new elie_emile_Cuisine(2,1,"Chicken Fry","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Rice African"));
        cuisines.add(new elie_emile_Cuisine(3,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
        cuisines.add(new elie_emile_Cuisine(4,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
    }
    private void initViews(){
        pojoData();
        restaurantAdapter = new elie_emile_RestaurantAdapter(elie_emile_Activity.this,restaurants);
        cuisineAdapter = new elie_emile_OrderAdapter(elie_emile_Activity.this,cuisines);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(restaurantAdapter);
        LinearLayoutManager lManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cuisine_list.setLayoutManager(lManager);
        cuisine_list.setAdapter(cuisineAdapter);
        if(swiperefresh.isRefreshing()){
            swiperefresh.setRefreshing(false);
        }
    }
}