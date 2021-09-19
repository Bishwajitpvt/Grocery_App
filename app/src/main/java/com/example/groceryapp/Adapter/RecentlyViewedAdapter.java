package com.example.groceryapp.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryapp.ProductDetails;
import com.example.groceryapp.R;
import com.example.groceryapp.model.RecentlyViewItem;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder> {

    Context context;
    List<RecentlyViewItem> recentlyViewItemList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewItem> recentlyViewItemList) {
        this.context = context;
        this.recentlyViewItemList = recentlyViewItemList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_view_item, parent, false);

        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, final int position) {

        holder.name.setText(recentlyViewItemList.get(position).getName());
        holder.description.setText(recentlyViewItemList.get(position).getDescription());
        holder.price.setText(recentlyViewItemList.get(position).getPrice());
        holder.qty.setText(recentlyViewItemList.get(position).getQuantity());
        holder.unit.setText(recentlyViewItemList.get(position).getUnit());
        holder.bg.setBackgroundResource(recentlyViewItemList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetails.class);
                i.putExtra("name", recentlyViewItemList.get(position).getName());
                i.putExtra("image", recentlyViewItemList.get(position).getBigimageurl());
                i.putExtra("price",recentlyViewItemList.get(position).getPrice());
                i.putExtra("desc",recentlyViewItemList.get(position).getDescription());
                i.putExtra("qty",recentlyViewItemList.get(position).getQuantity());
                i.putExtra("unit",recentlyViewItemList.get(position).getUnit());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return recentlyViewItemList.size();
    }

    public static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{
        TextView name, description, price, qty, unit;
        ConstraintLayout bg;
        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.qty);
            unit = itemView.findViewById(R.id.unit);
            bg = itemView.findViewById(R.id.recently_layout);
        }
    }

}
