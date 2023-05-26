package com.example.medease.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medease.R;
import com.example.medease.databinding.FragmentSearchShopBinding;
import com.example.medease.databinding.FragmentShopBinding;

public class SearchShopFragment extends Fragment {
    FragmentSearchShopBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchShopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }
}