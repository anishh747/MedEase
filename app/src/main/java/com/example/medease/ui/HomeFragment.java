package com.example.medease.ui;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medease.DoctorListActivity;
import com.example.medease.Model.Doctors;
import com.example.medease.Model.NormalUsers;

import com.example.medease.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding homepagBindinge;

    TextView username ;
    CircleImageView userimage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        getUserType();

        homepagBindinge = FragmentHomeBinding.inflate(inflater, container, false);
        View root = homepagBindinge.getRoot();

        homepagBindinge.cardiologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomeFragment.this.getActivity(), DoctorListActivity.class);
            intent.putExtra("Cardview","Cardiology");
            startActivity(intent);
        });
        homepagBindinge.pulmonologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomeFragment.this.getActivity(), DoctorListActivity.class);
            intent.putExtra("Cardview","Pulmonology");
            startActivity(intent);
        });
        homepagBindinge.dentalcardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomeFragment.this.getActivity(), DoctorListActivity.class);
            intent.putExtra("Cardview","Dental");
            startActivity(intent);
        });
        homepagBindinge.opthalmologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomeFragment.this.getActivity(), DoctorListActivity.class);
            intent.putExtra("Cardview","Opthalmology");
            startActivity(intent);
        });
        homepagBindinge.gynecologycardview.setOnClickListener(v -> {
            Intent intent = new Intent(HomeFragment.this.getActivity(), DoctorListActivity.class);
            intent.putExtra("Cardview","Gynecology");
            startActivity(intent);
        });

        return root;
    }

    private void getUserType() {

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        usersRef.child("Users").child("Doctor").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    getUserInformation("Doctor");

                } else {
                    // The current user is not a doctor, so check if they are a normal user
                    usersRef.child("Users").child("NormalUsers").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {

                                getUserInformation("NormalUsers");

                            } else {
                                // The current user is neither a doctor nor a normal user
                                // Do whatever you need to do here
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            // Handle any errors here
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors here
            }
        });

    }

    private void getUserInformation(String userType) {
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userType).child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (userType.equals("NormalUsers")) {
                        NormalUsers user = snapshot.getValue(NormalUsers.class);
                        Log.i("Normal User Name",user.getUsername());
                        homepagBindinge.textView3.setText(user.getUsername());

                        if (user.getImage() != null) {
                            Picasso.get().load(user.getImage()).into(homepagBindinge.homepageImage);
                        }
                    } else if (userType.equals("Doctors")) {
                        Doctors doctor = snapshot.getValue(Doctors.class);
                        homepagBindinge.textView3.setText(doctor.getUsername());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, "getUserInformation: onCancelled: " + error.getMessage());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        homepagBindinge = null;
    }
}