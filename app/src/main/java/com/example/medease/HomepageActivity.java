package com.example.medease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.medease.Adapter.MedicalFieldAdapter;
import com.example.medease.Model.Doctors;
import com.example.medease.Model.MedicalFieldModel;
import com.example.medease.databinding.ActivityHomepageActivityBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomepageActivity extends AppCompatActivity {

    ArrayList<MedicalFieldModel> medicalFieldModelArrayList = new ArrayList<>();
    MedicalFieldAdapter medicalFieldAdapter;
    RecyclerView medicalfieldrecyclerview;
    ActivityHomepageActivityBinding homepage;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_homepage_activity);
        ActivityHomepageActivityBinding homepage = ActivityHomepageActivityBinding.inflate(getLayoutInflater());
        setContentView(homepage.getRoot());


        homepage.cardiologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, DoctorListActivity.class);
            intent.putExtra("Cardview","Cardiology");
            startActivity(intent);
        });
        homepage.pulmonologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, DoctorListActivity.class);
            intent.putExtra("Cardview","Pulmonology");
            startActivity(intent);
        });
        homepage.dentalcardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, DoctorListActivity.class);
            intent.putExtra("Cardview","Dental");
            startActivity(intent);
        });
        homepage.opthalmologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, DoctorListActivity.class);
            intent.putExtra("Cardview","Opthalmology");
            startActivity(intent);
        });
        homepage.gynecologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, DoctorListActivity.class);
            intent.putExtra("Cardview","Gynecology");
            startActivity(intent);
        });





    }


}