package com.example.admin.foodmenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class BurgerMenuActivity extends AppCompatActivity {
    int[] images = {R.drawable.aloo_tikki_burger, R.drawable.del_beef_burger, R.drawable.hamburg_pck, R.drawable.veg_burger, R.drawable.steak_burger, R.drawable.gourmet_burger, R.drawable.crispy_chicken_burger, R.drawable.ketchup_burger,R.drawable.barbecue_burger,R.drawable.fried_chicken_burger};

    int[] category = {R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg};


    String[] version = {"Aloo Tikki Burger", "Delicious Beef Burger", "Hamburg Package Burger", "Veg Tikki Burger", "Steak Burger", "Gourmet Burger", "Crispy Chicken Burger", "Ketchup Burger","Barbecue Burger","Fried Chicken Burger"};

    String[] ingredients = {"(Onion,Olive,Tomato,Paneer,SweetCorn,Cabbage,Spinach,Carrot)",
            "(Onion,Mushroom,Tomato,Cucumber,Corriander leaves,Cabbage,Spinach,Carrot)",
            "(Strawberry,Grapes,Papaya,Banana,Mango,Orange)", "(Onion,Boiled Egg,Yogurt,Cucumber,Lemon,Cabbage,Spinach,Carrot)",
            "(Papaya,Banana,Mushroom,Curd,Cheese,Carrot)", "(Strawberry,Cherry,Cream,Milk,WaterMelon)",
            "(Egg,Broccoli,Capsicum,Paneer,Corriander Leaves)", "(Steamed Lobster,Cheese,Paneer,SweetCorn,Carrot)",
            "(Steamed Lobster,Cheese,Paneer,SweetCorn,Carrot)",
            "(Steamed Lobster,Cheese,Paneer,SweetCorn,Carrot)","(Steamed Lobster,Cheese,Paneer,SweetCorn,Carrot)"};

    String[] versionNumber = {"50", "250", "180", "65", "255", "195", "255", "100","300","350"};

    ListView burgerListView;

    BurgerListAdapter burgerListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        burgerListView = (ListView) findViewById(R.id.burgerMenuList);

        burgerListAdapter = new BurgerListAdapter(BurgerMenuActivity.this, version, versionNumber, ingredients, category, images);

        burgerListView.setAdapter(burgerListAdapter);

        burgerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(BurgerMenuActivity.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
