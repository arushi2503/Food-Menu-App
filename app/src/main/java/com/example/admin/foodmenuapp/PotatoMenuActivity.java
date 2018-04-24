package com.example.admin.foodmenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PotatoMenuActivity extends AppCompatActivity {
    int[] images = {R.drawable.fried_potato, R.drawable.fried_potatoes, R.drawable.potato_baked_rice, R.drawable.potato_chips_griddle_cuisine, R.drawable.potato_dish, R.drawable.small_potato_fried_meat, R.drawable.steamed_potato};

    int[] category = {R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_veg};

    String[] version = {"French Fries", "Fried Potatoes", "Potato Baked Rice", "Potato Chips Griddle Cuisine", "Stuffed Potato Dish ", "Small Potato Fried Meat", "Steamed Potato"};

    String[] ingredients = {"(Onion,Olive,Tomato,Paneer,SweetCorn,Cabbage,Spinach,Carrot)",
            "(Onion,Mushroom,Tomato,Cucumber,Corriander leaves,Cabbage,Spinach,Carrot)",
            "(Strawberry,Grapes,Papaya,Banana,Mango,Orange)", "(Onion,Boiled Egg,Yogurt,Cucumber,Lemon,Cabbage,Spinach,Carrot)",
            "(Papaya,Banana,Mushroom,Curd,Cheese,Carrot)", "(Strawberry,Cherry,Cream,Milk,WaterMelon)",
            "(Egg,Broccoli,Capsicum,Paneer,Corriander Leaves)", };

    String[] versionNumber = {"45", "120", "230", "350", "130", "395", "155"};

    ListView potatoListView;

    PotatoListAdapter potatoListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        potatoListView = (ListView) findViewById(R.id.potatoMenuList);

        potatoListAdapter = new PotatoListAdapter(PotatoMenuActivity.this, version, versionNumber, ingredients, category, images);

        potatoListView.setAdapter(potatoListAdapter);

        potatoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(PotatoMenuActivity.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
