package com.example.admin.foodmenuapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private Context mContext;
    private List<Menu> menuList;
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public RelativeLayout relative_layout_main;

        public MyViewHolder(View view)  {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
            relative_layout_main = (RelativeLayout) view.findViewById(R.id.relative_layout_main);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Menu menu = new Menu();
            menu= menuList.get(position);
            Toast.makeText(mContext,"VALUES: "+ menu.getNameOfDish(),Toast.LENGTH_SHORT).show();
            Intent i;
            switch (position){
                case 0:
                    i = new Intent(mContext,SaladMenuActivity.class);
                    i.putExtra("key",menu);
                    mContext.startActivity(i);
                    break;
                case 1:
                    i = new Intent(mContext,NoodlesCategoryActivity.class);
                    i.putExtra("key",menu);
                    mContext.startActivity(i);
                    break;
                case 2:
                    i = new Intent(mContext,PotatoMenuActivity.class);
                    i.putExtra("key",menu);
                    mContext.startActivity(i);
                    break;
                case 3:
                    i = new Intent(mContext,BurgerMenuActivity.class);
                    i.putExtra("key",menu);
                    mContext.startActivity(i);
                    break;
                    default:
                        i = new Intent(mContext,MenuCategoriesActivity.class);
                        mContext.startActivity(i);
                        break;
            }
            //Intent i;
            //i = new Intent(mContext,SaladMenuActivity.class);
            //i.putExtra("key",menu);
            //mContext.startActivity(i);
        }
    }



    public MenuAdapter(Context mContext, List<Menu> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        holder.title.setText(menu.getNameOfDish());
        holder.count.setText(menu.getNumOfDish() + " dishes");

        // loading album cover using Glide library
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_dish, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_add_cart:
                    Toast.makeText(mContext, "Add to Cart", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}