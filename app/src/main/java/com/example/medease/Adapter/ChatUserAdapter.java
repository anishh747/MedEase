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

public class ChatUserAdapter extends RecyclerView.Adapter<ChatUserAdapter.ViewHolder> {

    List<Doctors> chatUserList;
    Context context;

    public ChatUserAdapter(Context context, List<Doctors> chatUserList) {
        this.context = context;
        this.chatUserList = chatUserList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userimage;
        TextView usernametextview;
        TextView chatuserfield;
        TextView chatuserexperience;
        TextView chatuserprice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userimage = itemView.findViewById(R.id.userlistimage);
            usernametextview = itemView.findViewById(R.id.userlistusernametextview);
            chatuserfield = itemView.findViewById(R.id.chatuserfield);
            chatuserexperience = itemView.findViewById(R.id.chatuserexperience);
            chatuserprice = itemView.findViewById(R.id.chatuserprice);
        }
    }

    @NonNull
    @Override
    public ChatUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chatindividualuseractivity, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ChatUserAdapter.ViewHolder holder, int position) {
        Doctors doctors = chatUserList.get(position);
        holder.usernametextview.setText(doctors.getUsername());
        holder.chatuserfield.setText(doctors.getSpeciality());
        holder.chatuserexperience.setText(doctors.getExperience());

    }

    @Override
    public int getItemCount() {
        return chatUserList.size();
    }


}
