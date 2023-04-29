package com.example.medease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.medease.databinding.ActivityCheckoutBinding;
import com.example.medease.databinding.ActivityProductDetailsBinding;
import com.example.medease.ui.ShopFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle bundle =getIntent().getExtras();
        String totalPrice = bundle.getString("TotalPrice");
        binding.productCost.setText("Rs "+totalPrice);
        String totalPayment = Integer.toString(Integer.parseInt(totalPrice) + 150);
        binding.totalPayment.setText("Rs "+totalPayment);

        binding.medeasepointcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.address.getText().toString().isEmpty()){
                    binding.address.setError("Empty Address");
                }else{
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                    HashMap<String,Object> map = new HashMap<>();
                map.put("UserID", FirebaseAuth.getInstance().getCurrentUser().getUid());
                map.put("Address",binding.address.getText().toString());
                map.put("TotalCost",totalPayment);


                    databaseReference.child("MyOrders").child(FirebaseAuth.getInstance().getUid()).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            startActivity(new Intent(CheckoutActivity.this, PaymentSuccessActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(CheckoutActivity.this,"Error:"+e.getMessage(),Toast.LENGTH_SHORT).show();
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