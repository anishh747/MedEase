package com.example.medease.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.medease.Model.Products;
import com.example.medease.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchShopAdapter extends RecyclerView.Adapter<SearchShopAdapter.ViewHolder> {

    List<Products> shoplist;
    Context context;

    public SearchShopAdapter(Context context, List<Products> shoplist) {
        this.context = context;
        this.shoplist = shoplist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productimage;
        private TextView itemname;
        private  TextView quantity;
        private TextView price;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            productimage =(ImageView)itemView.findViewById(R.id.prodImageMyCart);
            itemname= itemView.findViewById(R.id.itemNameViewOrder);
            price = itemView.findViewById(R.id.productPriceMyCart);
        }
    }


    @NonNull
    @Override
    public SearchShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.indvidualitem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchShopAdapter.ViewHolder holder, int position) {
        Products products =  shoplist.get(position);
        holder.itemname.setText(products.getProductName());
        holder.price.setText(products.getProductPrice());
        if(products.getImageUrl() != null){
            Picasso.get().load(products.getImageUrl()).into(holder.productimage);
        }else{
            Log.i("SearchShop Adapter ","Product image null");
        }

    }

    @Override
    public int getItemCount() {
        Log.i("SearchShopAdapter", String.valueOf(shoplist.size()));
        return shoplist.size();
    }


}
