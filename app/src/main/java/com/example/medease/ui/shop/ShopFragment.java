package com.example.medease.ui.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medease.Adapter.ProductAdapter;
import com.example.medease.Model.Products;
import com.example.medease.R;
import com.example.medease.databinding.FragmentShopBinding;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    private FragmentShopBinding binding;

    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ShopViewModel shopViewModel =
                new ViewModelProvider(this).get(ShopViewModel.class);

        binding = FragmentShopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        shopViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        prodItemRecycler=binding.productRecycler;
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.appointmenticon));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.baseline_shopping_cart_24));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.appointmenticon));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.baseline_shopping_cart_24));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.appointmenticon));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.baseline_shopping_cart_24));

        setProdItemRecycler(productsList);



        return root;
    }

    private void setProdItemRecycler(List<Products> productsList) {



        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ShopFragment.this.getActivity(), RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(ShopFragment.this.getActivity(), productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}