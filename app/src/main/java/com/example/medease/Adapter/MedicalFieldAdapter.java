package com.example.medease.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medease.Model.MedicalFieldModel;
import com.example.medease.R;

import java.util.ArrayList;

public class MedicalFieldAdapter extends RecyclerView.Adapter<MedicalFieldAdapter.ViewHolder> {

    ArrayList<MedicalFieldModel> arrayList;
    Context context;

    public MedicalFieldAdapter(Context context, ArrayList<MedicalFieldModel> medicalFieldModelArrayList) {
        this.context = context;
        this.arrayList = medicalFieldModelArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView medicalfieldimage ;
        TextView medicalfieldname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            medicalfieldimage = itemView.findViewById(R.id.medicalfieldimage);
            medicalfieldname = itemView.findViewById(R.id.medicalfieldname);
        }
    }


    @NonNull
    @Override
    public MedicalFieldAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemmedicalfield, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MedicalFieldAdapter.ViewHolder holder, int position) {

        holder.medicalfieldimage.setImageResource(arrayList.get(position).getImage());
        holder.medicalfieldname.setText(arrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
