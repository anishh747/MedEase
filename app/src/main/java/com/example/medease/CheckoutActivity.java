package com.example.medease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.medease.databinding.ActivityCheckoutBinding;
import com.example.medease.databinding.ActivityProductDetailsBinding;

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
        binding.productCost.setText(totalPrice);
        String totalPayment = Integer.toString(Integer.parseInt(totalPrice) + 150);
        binding.totalPayment.setText("Rs"+totalPayment);
    }
}