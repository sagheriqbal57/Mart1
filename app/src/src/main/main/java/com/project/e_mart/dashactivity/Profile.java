package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.e_mart.R;

public class Profile extends AppCompatActivity {

    Button logoutBtn;
    TextView nameView, emailView,pass_count,change_pass;

    ImageView backBtn;
    SharedPreferences sharedPreferences;
    int p_count=0;

    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth=FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user==null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLogin",false);
            editor.apply();

            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }

        sharedPreferences = getSharedPreferences("E-Mart",MODE_PRIVATE);
        String p_name = sharedPreferences.getString("username","");
        String p_email = sharedPreferences.getString("email","");
        String p_pass = sharedPreferences.getString("password","");



        pass_count = findViewById(R.id.pass_count);
        p_count = p_pass.length();

        char[] charArray = new char[p_count];
        for (int i=0;i<p_count;i++)
        {
            charArray[i]='*';
        }
    String pass = new String(charArray);


        nameView = findViewById(R.id.name);
        emailView = findViewById(R.id.email);
        backBtn = findViewById(R.id.backbtn);
        change_pass = findViewById(R.id.change_pass);

change_pass.setOnClickListener(v -> startActivity(new Intent(Profile.this,ChangePassword.class)));

        nameView.setText(p_name);
        emailView.setText(p_email);
        pass_count.setText(pass);



        logoutBtn = findViewById(R.id.logoutBtn);

        backBtn.setOnClickListener(v -> startActivity(new Intent(Profile.this,MainActivity2.class)));

        logoutBtn.setOnClickListener(v -> {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLogin",false);
            editor.apply();
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        });
    }
}