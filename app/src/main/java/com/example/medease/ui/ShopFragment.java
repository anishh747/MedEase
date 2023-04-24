package com.example.medease.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medease.Adapter.ProductAdapter;
import com.example.medease.AddProducts;
import com.example.medease.Model.Products;
import com.example.medease.MyCartActivity;
import com.example.medease.R;
import com.example.medease.databinding.FragmentShopBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FragmentShopBinding binding;

    RecyclerView prodItemRecycler1, prodItemRecycler2, prodItemRecycler3, searchRecycler;
    ProductAdapter productAdapter;

    SearchView searchView;
    List<Products> productsList1 = new ArrayList<>();
    List<Products> productsList2 = new ArrayList<>();
    List<Products> productsList3 = new ArrayList<>();
    List<Products> allProductList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentShopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        searchView = binding.searchView;
        searchRecycler = binding.searchRecycler;
        prodItemRecycler1=binding.productRecycler1;
        prodItemRecycler2=binding.productRecycler2;
        prodItemRecycler3=binding.productRecycler3;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Products");

        binding.addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopFragment.this.getActivity(), AddProducts.class));
            }
        });

        binding.myCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopFragment.this.getActivity(), MyCartActivity.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });



        databaseReference.child("Medicines").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Products products = dataSnapshot.getValue(Products.class);

                    productsList1.add(products);
                    allProductList.add(products);
                }
                databaseReference.child("Nutrition").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Products products = dataSnapshot.getValue(Products.class);

                            productsList2.add(products);
                            allProductList.add(products);

                        }
                        databaseReference.child("Other").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    Products products = dataSnapshot.getValue(Products.class);

                                    productsList3.add(products);
                                    allProductList.add(products);

                                }
                                setProdItemRecycler();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(ShopFragment.this.getActivity(), "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ShopFragment.this.getActivity(), "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return root;
    }

    private void setProdItemRecycler() {
        RecyclerView.LayoutManager layoutManager1= new LinearLayoutManager(ShopFragment.this.getActivity(), RecyclerView.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager2= new LinearLayoutManager(ShopFragment.this.getActivity(), RecyclerView.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager3= new LinearLayoutManager(ShopFragment.this.getActivity(), RecyclerView.HORIZONTAL, false);

        prodItemRecycler1.setLayoutManager(layoutManager1);
        prodItemRecycler2.setLayoutManager(layoutManager2);
        prodItemRecycler3.setLayoutManager(layoutManager3);
        productAdapter = new ProductAdapter(ShopFragment.this.getActivity(), productsList1);
        prodItemRecycler1.setAdapter(productAdapter);
        productAdapter = new ProductAdapter(ShopFragment.this.getActivity(), productsList2);
        prodItemRecycler2.setAdapter(productAdapter);
        productAdapter = new ProductAdapter(ShopFragment.this.getActivity(), productsList3);
        prodItemRecycler3.setAdapter(productAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}