package com.capstoneproject.elie_emile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.capstoneproject.elie_emile.R;

import java.util.ArrayList;


public class elie_emile_OrderActivity extends AppCompatActivity {
    int restaurant_id;
    String name,image_url,description;
    private Toolbar toolbar;
    private ImageView image_restaurant;
    private TextView rest_name,res_description;
    private ArrayList<elie_emile_Restaurant>restaurants;
    private ArrayList<elie_emile_Cuisine>cuisines;
    private elie_emile_RestaurantAdapter restaurantAdapter;
    private elie_emile_OrderAdapter cuisineAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rest_cuisine_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elie_emile_activity_order);
        toolbar = findViewById(R.id.home_toolbar);
        image_restaurant = findViewById(R.id.image_restaurant);
        rest_name = findViewById(R.id.rest_name);
        res_description = findViewById(R.id.res_description);
        rest_cuisine_list = findViewById(R.id.rest_cuisine_list);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getExtra();
    }
    private void getExtra(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            restaurant_id = extras.getInt("restaurant_id");
            name = extras.getString("res_name");
            image_url = extras.getString("image_url");
            description = extras.getString("description");
        }else{
            finish();
        }
        toolbar.setTitle(name);
        rest_name.setText("Restaurant : "+name);
        res_description.setText(description);
        Glide.with(this).load(image_url).placeholder(R.drawable.placeholder).into(image_restaurant);
        pojoData(restaurant_id);
    }
    private void pojoData(int restaurant_id){
        cuisines = new ArrayList<>();
        if(restaurant_id == 1){
            cuisines.add(new elie_emile_Cuisine(1,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/164.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(2,1,"Chicken Fry","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(3,1,"Meat","https://www.delonghi.com/Global/recipes/multifry/165.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(4,1,"Potatoes","https://www.delonghi.com/Global/recipes/multifry/166.jpg","5,000 Frw","Rice African"));
        }else if(restaurant_id == 2){
            cuisines.add(new elie_emile_Cuisine(1,1,"Igitoki","https://www.delonghi.com/Global/recipes/multifry/170.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(2,1,"Nyamachoka","https://www.delonghi.com/Global/recipes/multifry/171.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(3,1,"Price Tag","https://www.delonghi.com/Global/recipes/multifry/173.jpg","15,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(4,1,"King Burger","https://www.delonghi.com/Global/recipes/multifry/174.jpg","3,000 Frw","Rice African"));
        }else if(restaurant_id == 3){
            cuisines.add(new elie_emile_Cuisine(1,1,"Inyama","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(2,1,"Chicken Leg","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(3,1,"King Burger","https://www.delonghi.com/Global/recipes/multifry/173.jpg","3,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(4,1,"Price Tag","https://www.delonghi.com/Global/recipes/multifry/172.jpg","15,000 Frw","Rice African"));
        }else if(restaurant_id == 4){
            cuisines.add(new elie_emile_Cuisine(1,1,"Inyama","https://www.delonghi.com/Global/recipes/multifry/170.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(2,1,"Chicken Leg","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(3,1,"King Burger","https://www.delonghi.com/Global/recipes/multifry/169.jpg","3,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(4,1,"Price Tag","https://www.delonghi.com/Global/recipes/multifry/168.jpg","15,000 Frw","Rice African"));
        }else {
            cuisines.add(new elie_emile_Cuisine(1,1,"Inyama","https://www.delonghi.com/Global/recipes/multifry/172.jpg","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(2,1,"Chicken Leg","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(3,1,"King Burger","https://www.delonghi.com/Global/recipes/multifry/171.jpg","3,000 Frw","Rice African"));
            cuisines.add(new elie_emile_Cuisine(4,1,"Price Tag","https://www.delonghi.com/Global/recipes/multifry/170.jpg","15,000 Frw","Rice African"));
        }

        cuisineAdapter = new elie_emile_OrderAdapter(this,cuisines);
        GridLayoutManager lManager = new GridLayoutManager(elie_emile_OrderActivity.this, 2);
        rest_cuisine_list.setLayoutManager(lManager);
        rest_cuisine_list.setAdapter(cuisineAdapter);
    }
}