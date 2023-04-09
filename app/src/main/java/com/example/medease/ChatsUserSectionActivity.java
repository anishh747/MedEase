package com.example.medease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.medease.Adapter.ChatUserAdapter;
import com.example.medease.Model.Doctors;
import com.example.medease.databinding.ActivityChatsUserSectionBinding;
import com.example.medease.databinding.ActivityDoctorListBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatsUserSectionActivity extends AppCompatActivity {

    private List<Doctors> doctorsList;
    ActivityChatsUserSectionBinding binding;
    ChatUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chats_user_section);
        binding = ActivityChatsUserSectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        doctorsList= new ArrayList<>();

        adapter = new ChatUserAdapter(getApplicationContext(),doctorsList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.chatuserrecyclerview.setLayoutManager(linearLayoutManager);
        binding.chatuserrecyclerview.setAdapter(adapter);
        getChatUsers();
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
}