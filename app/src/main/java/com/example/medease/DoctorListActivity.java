package com.example.medease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.medease.Adapter.DoctorListAdapter;
import com.example.medease.Model.Doctors;
import com.example.medease.databinding.ActivityDoctorListBinding;
import com.example.medease.databinding.ActivityHomepageActivityBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DoctorListActivity extends AppCompatActivity {

    ActivityDoctorListBinding doctorListBinding;
    List<Doctors> doctorsList;
    DoctorListAdapter doctorListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_doctor_list);

        doctorListBinding = ActivityDoctorListBinding.inflate(getLayoutInflater());
        setContentView(doctorListBinding.getRoot());


        doctorsList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        doctorListBinding.userlistrecyclerview.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        String intentextra = intent.getStringExtra("Cardview");
        Toast.makeText(this, intentextra, Toast.LENGTH_SHORT).show();

        switch (intentextra){
            case ("Cardiology"):
                getCardiologist();
                break;

            case ("Pulmonology"):
                getPulmonologist();
                break;

            case ("Dental"):
                getDentist();
                break;

            case ("Opthalmology"):
                getOpthalmologist();
                break;

            case ("Gynecology"):
                getGynecologist();
                break;
        }


    }

    private void getGynecologist() {
        FirebaseDatabase.getInstance().getReference().child("Users").child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Doctors doctors =  dataSnapshot.getValue(Doctors.class);
                    if(doctors.getSpeciality().equals("Gynecologist")){
                        Toast.makeText(DoctorListActivity.this, "Gynecologist found", Toast.LENGTH_SHORT).show();
                        doctorsList.add(doctors);
                    }
                }

                doctorListAdapter = new DoctorListAdapter(getApplicationContext(),doctorsList);
                doctorListBinding.userlistrecyclerview.setAdapter(doctorListAdapter);
                doctorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getOpthalmologist() {
        FirebaseDatabase.getInstance().getReference().child("Users").child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Doctors doctors =  dataSnapshot.getValue(Doctors.class);
                    if(doctors.getSpeciality().equals("Opthalmologist")){
                        Toast.makeText(DoctorListActivity.this, "Opthalmologist found", Toast.LENGTH_SHORT).show();
                        doctorsList.add(doctors);
                    }
                }
                doctorListAdapter = new DoctorListAdapter(getApplicationContext(),doctorsList);
                doctorListBinding.userlistrecyclerview.setAdapter(doctorListAdapter);
                doctorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getPulmonologist() {
        FirebaseDatabase.getInstance().getReference().child("Users").child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Doctors doctors =  dataSnapshot.getValue(Doctors.class);
                    if(doctors.getSpeciality().equals("Pulmonologist")){
                        Toast.makeText(DoctorListActivity.this, "Pulmonologist found", Toast.LENGTH_SHORT).show();
                        doctorsList.add(doctors);
                    }
                }

                doctorListAdapter = new DoctorListAdapter(getApplicationContext(),doctorsList);
                doctorListBinding.userlistrecyclerview.setAdapter(doctorListAdapter);
                doctorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getDentist() {
        FirebaseDatabase.getInstance().getReference().child("Users").child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Doctors doctors =  dataSnapshot.getValue(Doctors.class);
                    if(doctors.getSpeciality().equals("Dentist")){
                        Toast.makeText(DoctorListActivity.this, "Dentist found", Toast.LENGTH_SHORT).show();
                        doctorsList.add(doctors);
                    }
                }

                doctorListAdapter = new DoctorListAdapter(getApplicationContext(),doctorsList);
                doctorListBinding.userlistrecyclerview.setAdapter(doctorListAdapter);
                doctorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getCardiologist() {
        FirebaseDatabase.getInstance().getReference().child("Users").child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Doctors doctors =  dataSnapshot.getValue(Doctors.class);
                    if(doctors.getSpeciality()!= null && doctors.getSpeciality().equals("Cardiologist")){
                        Toast.makeText(DoctorListActivity.this, "Cardiologist found", Toast.LENGTH_SHORT).show();
                        doctorsList.add(doctors);
                    }
                }

                doctorListAdapter = new DoctorListAdapter(getApplicationContext(),doctorsList);
                doctorListBinding.userlistrecyclerview.setAdapter(doctorListAdapter);
                doctorListAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}