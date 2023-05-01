package com.example.medease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.medease.Model.Products;
import com.example.medease.databinding.ActivityCheckoutBinding;
import com.example.medease.databinding.ActivityProductDetailsBinding;
import com.example.medease.ui.ShopFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        DatabaseReference orderRef = databaseReference.child("MyOrders").child(FirebaseAuth.getInstance().getUid());
        DatabaseReference cartRef = databaseReference.child("MyCart").child(FirebaseAuth.getInstance().getUid());

        Bundle bundle =getIntent().getExtras();
        String totalPrice = bundle.getString("TotalPrice");
        binding.productCost.setText("Rs "+totalPrice);
        String totalPayment = Integer.toString(Integer.parseInt(totalPrice) + 150);
        binding.totalPayment.setText("Rs "+totalPayment);

        HashMap<Object,Object> map = new HashMap<>();

        HashMap<Object,Object> map1 = new HashMap<>();

        binding.medeasepointcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.address.getText().toString().isEmpty()){
                    binding.address.setError("Empty Address");
                }else{
                    map.put("UserID", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    map.put("Address",binding.address.getText().toString());
                    map.put("TotalCost",totalPayment);
                    orderRef.setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(CheckoutActivity.this,"Error:"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });

                    cartRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Products products = dataSnapshot.getValue(Products.class);
                                map1.put("productPrice",products.getProductPrice());
                                map1.put("productQuantity",products.getProductQuantity());

                                orderRef.child("Products").child(products.getProductName()).setValue(map1).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(CheckoutActivity.this,"Error in Products:"+e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            cartRef.removeValue();
                            Toast.makeText(CheckoutActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




                }

            }
        });

        binding.esewacardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CheckoutActivity.this, "Feature available soon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.imaepaycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CheckoutActivity.this, "Feature available soon", Toast.LENGTH_SHORT).show();

            }
        });

        binding.khalticardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CheckoutActivity.this, "Feature available soon", Toast.LENGTH_SHORT).show();

            }
        });
    }
}