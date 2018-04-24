package com.example.admin.foodmenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SaladMenuActivity extends AppCompatActivity {
    int[] images = {R.drawable.veg_salad, R.drawable.green_salad, R.drawable.mix_fruit_slad, R.drawable.egg_salad, R.drawable.papaya_salad, R.drawable.straw_salad, R.drawable.eggplant_salad, R.drawable.lobster_salad};

    int[] category = {R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg};

    String[] version = {"Vegetable Salad", "Green Salad", "Mix Fruit Salad", "Egg Salad", "Papaya Salad", "Strawberry Salad", "Egg Plant Salad", "Lobster Salad"};

    String[] ingredients = {"(Onion,Olive,Tomato,Paneer,SweetCorn,Cabbage,Spinach,Carrot)",
            "(Onion,Mushroom,Tomato,Cucumber,Corriander leaves,Cabbage,Spinach,Carrot)",
            "(Strawberry,Grapes,Papaya,Banana,Mango,Orange)", "(Onion,Boiled Egg,Yogurt,Cucumber,Lemon,Cabbage,Spinach,Carrot)",
            "(Papaya,Banana,Mushroom,Curd,Cheese,Carrot)", "(Strawberry,Cherry,Cream,Milk,WaterMelon)",
            "(Egg,Broccoli,Capsicum,Paneer,Corriander Leaves)", "(Steamed Lobster,Cheese,Paneer,SweetCorn,Carrot)"};

    String[] versionNumber = {"65", "100", "130", "50", "55", "95", "155", "230"};

    ListView saladListView;

    SaladListAdapter saladListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        saladListView = (ListView) findViewById(R.id.saladMenuList);

        saladListAdapter = new SaladListAdapter(SaladMenuActivity.this, version, versionNumber, ingredients, category, images);

        saladListView.setAdapter(saladListAdapter);

        saladListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(SaladMenuActivity.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
