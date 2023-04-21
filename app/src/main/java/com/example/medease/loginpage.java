package com.example.medease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.medease.databinding.ActivityLoginpageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity {

    private ActivityLoginpageBinding activityLoginpageBinding;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this is not required if we use View Binding
//        setContentView(R.layout.activity_loginpage);

        activityLoginpageBinding = ActivityLoginpageBinding.inflate(getLayoutInflater());
        View view = activityLoginpageBinding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();


        //Log.i("username",usernametext);
        activityLoginpageBinding.loginButton.setOnClickListener(v ->{
            String usernametext = String.valueOf(activityLoginpageBinding.email.getText());
            String password = String.valueOf(activityLoginpageBinding.password.getText());
            Log.i("username",usernametext);
        } );



        activityLoginpageBinding.signupuserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this, userregisteractivity.class));
            }
        });
        activityLoginpageBinding.loginButton.setOnClickListener(view1 -> {
            String email = activityLoginpageBinding.email.getText().toString();
            String password = activityLoginpageBinding.password.getText().toString();
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                Toast.makeText(loginpage.this, "Empty Columns", Toast.LENGTH_LONG).show();
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(loginpage.this, "Invalid Email Address", Toast.LENGTH_LONG).show();
            }
            else{
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(loginpage.this, "Login Sucessful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(loginpage.this, MainActivity.class));
                        }else{
                            Toast.makeText(loginpage.this, "Login Unsucessful", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(loginpage.this,MainActivity.class));
            finish();
        }
    }
}