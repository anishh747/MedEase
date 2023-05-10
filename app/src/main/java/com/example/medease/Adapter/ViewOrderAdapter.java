package com.example.medease.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.medease.Model.Products;
import com.example.medease.R;
import java.util.List;

public class ViewOrderAdapter extends RecyclerView.Adapter<ViewOrderAdapter.ViewOrderViewHolder> {

    Context context;
    List<Products> productsList;


    public ViewOrderAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ViewOrderAdapter.ViewOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.view_order_item, parent, false);
        return new ViewOrderAdapter.ViewOrderViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ViewOrderAdapter.ViewOrderViewHolder holder, int position) {
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());
        holder.prodQuantity.setText(productsList.get(position).getProductQuantity());
//
//        Log.e("Name",productsList.get(position).getProductName());
//        Log.e("Price",productsList.get(position).getProductPrice());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ViewOrderViewHolder extends RecyclerView.ViewHolder{

        TextView prodName, prodPrice,prodQuantity;

        public ViewOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            prodName = itemView.findViewById(R.id.itemNameViewOrder);
            prodPrice = itemView.findViewById(R.id.priceViewOrder);
            prodQuantity = itemView.findViewById(R.id.quantityViewOrder);


        }
    }
}
