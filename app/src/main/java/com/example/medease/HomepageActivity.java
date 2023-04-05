package com.example.medease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.medease.Adapter.MedicalFieldAdapter;
import com.example.medease.Model.MedicalFieldModel;

import java.util.ArrayList;
import java.util.HashMap;

public class HomepageActivity extends AppCompatActivity {

    ArrayList<MedicalFieldModel> medicalFieldModelArrayList = new ArrayList<>();
    MedicalFieldAdapter medicalFieldAdapter;
    RecyclerView medicalfieldrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_activity);

//        medicalfieldrecyclerview = findViewById(R.id.medicalfieldrecyclerview);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        medicalfieldrecyclerview.setLayoutManager(layoutManager);
//
//
//
//        medicalFieldModelArrayList.add(new MedicalFieldModel(R.drawable.heart,"CARDIOLOGIST"));
//        medicalFieldModelArrayList.add(new MedicalFieldModel(R.drawable.eyesicon,"OPTHALMOLOGIST"));
//        medicalFieldModelArrayList.add(new MedicalFieldModel(R.drawable.lungicon,"PULMONOLOGIST"));
//        medicalFieldModelArrayList.add(new MedicalFieldModel(R.drawable.teethicon,"DENTIST"));
//
//
//        medicalFieldAdapter = new MedicalFieldAdapter(this, medicalFieldModelArrayList);
//        medicalfieldrecyclerview.setAdapter(medicalFieldAdapter);



    }
}