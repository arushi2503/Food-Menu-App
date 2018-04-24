package com.example.admin.foodmenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class NoodlesCategoryActivity extends AppCompatActivity {
    int[] images = {R.drawable.beef_noodle, R.drawable.but_noodles, R.drawable.dry_noodle, R.drawable.pasta, R.drawable.plain_cheese_noodle, R.drawable.shrimp_fried_noodle, R.drawable.spicy_minced_meat_noodle, R.drawable.spicy_noodles, R.drawable.udon_noodle};

    int[] category = {R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_non_veg,R.drawable.dish_type_veg,R.drawable.dish_type_veg};

    String[] version = {"Beef Noodles", "But Noodles", "Dry Noodles", "Plain Pasta", "Plain Cheese Noodles", "Shrimp Fried Noodles", "Spicy Miced Meat Noodles", "Spicy Soupy Noodles", "Udon Noodles"};

    String[] ingredients = {"(Beef,Onion,Capsicum,Tomato,SweetCorn,Carrot)",
            "(But,Onion,Mushroom,Tomato,Corriander leaves,Carrot,Peas)",
            "(Dry Fried Noodles,Mix Vegetable chutney)", "(Penne Pasta,Onion,Tomato,Olive,Capsicum,Carrot,Oregano)",
            "(Butter,Onion,sweet Corn,Tomato,Capsicum,Cheese,Carrot)", "(Mushroom,Red Chillies,capsicum,Corriander Leaves,Tomato,Onion)",
            "(Onion,Tomato,Garlic,Ginger,Capsicum,Meat,Corriander Leaves)", "(Soup,Cheese,Onion,Tomato,Chillies,SweetCorn,Carrot)",
             "(Soup,Cheese,Onion,Tomato,Chillies,SweetCorn,Carrot)"};

    String[] versionNumber = {"465", "180", "130", "150", "90", "195", "355", "130", "320"};

    ListView NoodlesListView;

    NoodlesListAdapter NoodlesListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noodles_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        NoodlesListView = (ListView) findViewById(R.id.noodlesCategoryList);

        NoodlesListAdapter = new NoodlesListAdapter(NoodlesCategoryActivity.this, version, versionNumber, ingredients, category, images);

        NoodlesListView.setAdapter(NoodlesListAdapter);

        NoodlesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(NoodlesCategoryActivity.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
