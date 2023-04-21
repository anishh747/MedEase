package com.example.medease.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.medease.Adapter.ChatUserAdapter;
import com.example.medease.Model.Doctors;
import com.example.medease.databinding.FragmentFindADoctorBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FindADoctorFragment extends Fragment {


    private FragmentFindADoctorBinding fragmentFindADoctorBinding;
    private List<Doctors> doctorsList;
    ChatUserAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        fragmentFindADoctorBinding = FragmentFindADoctorBinding.inflate(inflater, container, false);
        View root = fragmentFindADoctorBinding.getRoot();


        doctorsList= new ArrayList<>();

        adapter = new ChatUserAdapter(getActivity(),doctorsList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FindADoctorFragment.this.getActivity());
        fragmentFindADoctorBinding.chatuserrecyclerview.setLayoutManager(linearLayoutManager);
        fragmentFindADoctorBinding.chatuserrecyclerview.setAdapter(adapter);
        getChatUsers();


        return root;
    }

    private void getChatUsers() {
        FirebaseDatabase.getInstance().getReference().child("Users").child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Doctors doctors = dataSnapshot.getValue(Doctors.class);
                    Log.i("String output",doctors.getUsername());
                    doctorsList.add(doctors);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentFindADoctorBinding = null;
    }

}