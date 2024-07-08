package com.project.e_mart.dashactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.e_mart.R;

public class Signup extends AppCompatActivity {

    TextView loginTxt;
    FirebaseAuth mAuth;
    EditText su_email,su_name,su_pass,su_c_pass;
    Button btnSignup;
    ImageButton showBtn,showBtn_c;
    boolean visible = false;
    SharedPreferences sharedPreferences;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressBar= findViewById(R.id.progressBar2);
        showBtn = findViewById(R.id.showBtn);
        mAuth = FirebaseAuth.getInstance();
        showBtn_c = findViewById(R.id.showBtnc);
        loginTxt = findViewById(R.id.login);
        su_email = findViewById(R.id.su_email);
        su_name = findViewById(R.id.su_name);
        su_pass = findViewById(R.id.su_pass);
        su_c_pass = findViewById(R.id.su_cpass);
        btnSignup = findViewById(R.id.btnSignup);

        sharedPreferences = getSharedPreferences("E-Mart",MODE_PRIVATE);
        loginTxt.setOnClickListener(v -> {

            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        });

        btnSignup.setOnClickListener(v -> {

            progressBar.setVisibility(View.VISIBLE);
            if (validation()) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email",su_email.getText().toString());
                editor.putString("username",su_name.getText().toString());
                editor.putString("password",su_pass.getText().toString());
                editor.apply();

                Intent intent= new Intent(Signup.this, Login.class);
                //intent.putExtra("name",su_name.getText().toString());
                startActivity(intent);
                finish();

            }

        });

        showBtn.setOnClickListener(v -> {
            if(visible){
                su_pass.setTransformationMethod(new PasswordTransformationMethod());
                showBtn.setImageResource(R.drawable.hide);
                visible=false;
            }
            else{
            su_pass.setTransformationMethod(null);
            showBtn.setImageResource(R.drawable.visible);
            visible=true;
            }
        });

        showBtn_c.setOnClickListener(v -> {
            if(visible){
                su_c_pass.setTransformationMethod(new PasswordTransformationMethod());
                showBtn_c.setImageResource(R.drawable.hide);
                visible=false;
            }
            else{
                su_c_pass.setTransformationMethod(null);
                showBtn_c.setImageResource(R.drawable.visible);
                visible=true;
            }
        });
    }

    private boolean validation() {
        String name, email, pass , c_pass;
        name = su_name.getText().toString();
        email = su_email.getText().toString();
        pass = su_pass.getText().toString();
        c_pass = su_c_pass.getText().toString();

        if(name.isEmpty())
        {
            Toast.makeText(this,"Name is required",Toast.LENGTH_SHORT).show();
            su_name.setError("Name is required");
            return false;
        } else if(email.isEmpty())
        {
            Toast.makeText(this,"E-Mail is required",Toast.LENGTH_SHORT).show();
            su_email.setError("E-Mail is required");
            return false;
        }
        else if(pass.isEmpty())
        {
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show();
            su_pass.setError("Password is required");
            return false;
        }
        else if(c_pass.isEmpty())
        {
            Toast.makeText(this,"Please Confirm Password",Toast.LENGTH_SHORT).show();
            su_c_pass.setError("Confirm Password is required");
            return false;
        } else if (pass.length()<8) {
            Toast.makeText(this,"Your Password must be of 8 characters",Toast.LENGTH_SHORT).show();
            return false;
        } else if (!pass.equals(c_pass)) {
            Toast.makeText(this,"Password & Confirm Password are not same !",Toast.LENGTH_SHORT).show();
            return false;
        } else if (email.equals(sharedPreferences.getString("email",""))) {
            Toast.makeText(this,"E-Mail Already Exists !",Toast.LENGTH_SHORT).show();
            return false;
        }
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Signup.this, "Account Created.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        return true;
    }
}