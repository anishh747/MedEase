package com.example.medease.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medease.Model.Doctors;
import com.example.medease.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.ViewHolder> {

    List<Doctors> doctorsList;
    Context context;

    public DoctorListAdapter(Context context, List<Doctors> doctorsList) {
        this.context = context;
        this.doctorsList = doctorsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userimage;
        private TextView username;
        private TextView doctorfieldname;
        private TextView experience;
        private TextView price;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userimage = itemView.findViewById(R.id.userlistimage);
            username = itemView.findViewById(R.id.userlistusernametextview);
            doctorfieldname = itemView.findViewById(R.id.chatuserfield);
            experience = itemView.findViewById(R.id.chatuserexperience);
            price = itemView.findViewById(R.id.chatuserprice);
        }
    }

    @NonNull
    @Override
    public DoctorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chatindividualuseractivity, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListAdapter.ViewHolder holder, int position) {

        Doctors doctors = doctorsList.get(position);
        holder.username.setText(doctors.getUsername());
        holder.doctorfieldname.setText(doctors.getSpeciality());
        holder.experience.setText(doctors.getExperience());

    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }


}
