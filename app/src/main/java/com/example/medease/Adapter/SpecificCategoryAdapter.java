package com.example.medease.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medease.Model.ProductCategory;
import com.example.medease.Model.Products;
import com.example.medease.ProductDetails;
import com.example.medease.R;
import com.example.medease.SpecificCategoryActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SpecificCategoryAdapter extends RecyclerView.Adapter<SpecificCategoryAdapter.SpecificCategoryViewHolder> {

    Context context;
    List<Products> productList;

    public SpecificCategoryAdapter(Context context, List<Products> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public SpecificCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.specific_category_items, parent, false);
        // lets create a recyclerview row item layout file
        return new SpecificCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificCategoryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.prodName.setText(productList.get(position).getProductName());
        holder.prodPrice.setText(productList.get(position).getProductPrice());
        Picasso.get().load(productList.get(position).getImageUrl()).into(holder.prodImage);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductDetails.class);
                i.putExtra("Product_Name",productList.get(position).getProductName());
                i.putExtra("Product_Price", productList.get(position).getProductPrice());
                i.putExtra("Image_Url",productList.get(position).getImageUrl());
                i.putExtra("Product_Description",productList.get(position).getProductDescription());

/*
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
               */
                context.startActivity(i/*, activityOptions.toBundle()*/);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static final class SpecificCategoryViewHolder extends RecyclerView.ViewHolder{


        ImageView prodImage;
        TextView prodName;
        TextView prodPrice;
        ConstraintLayout constraintLayout;
        public SpecificCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            prodImage = itemView.findViewById(R.id.prodImageMyCart);
            prodName = itemView.findViewById(R.id.itemNameViewOrder);
            prodPrice = itemView.findViewById(R.id.productPriceMyCart);
            constraintLayout = itemView.findViewById(R.id.outerLayout);
        }
    }

}