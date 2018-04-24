package com.example.admin.foodmenuapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class PotatoListAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    private final String [] numbers;
    private final String [] ingredients;
    private final int [] category;
    private final int [] images;

    public PotatoListAdapter(Context context, String[] values, String[] numbers, String[] ingredients, int[] category, int[] images){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.values = values;
        this.numbers = numbers;
        this.ingredients = ingredients;
        this.category = category;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        final ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_potato_list_item, parent, false);
            viewHolder.potatoName = (TextView) convertView.findViewById(R.id.potato_name);
            viewHolder.potatoIngredients = (TextView) convertView.findViewById(R.id.potato_ingredients);
            viewHolder.potatoPrice= (TextView) convertView.findViewById(R.id.potato_price);
            viewHolder.potatoImage = (ImageView) convertView.findViewById(R.id.potato_image);

            viewHolder.potatoCategory = (ImageView) convertView.findViewById(R.id.potato_cat);

            viewHolder.overflow = (ImageView) convertView.findViewById(R.id.overflow);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.potatoName.setText(values[position]);
        viewHolder.potatoIngredients.setText(ingredients[position]);
        viewHolder.potatoPrice.setText("$ "+numbers[position]);
        viewHolder.potatoImage.setImageResource(images[position]);
        viewHolder.potatoCategory.setImageResource(category[position]);

        viewHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(viewHolder.overflow);
            }
        });

        return convertView;
    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_dish, popup.getMenu());
        popup.setOnMenuItemClickListener(new PotatoListAdapter.MyMenuItemClickListener());
        popup.show();
    }
    private static class ViewHolder {

        TextView potatoName;
        TextView potatoIngredients;
        TextView potatoPrice;
        ImageView potatoImage;
        ImageView potatoCategory;

        ImageView overflow;

    }
    public class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(context, "Added to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_add_cart:
                    Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}