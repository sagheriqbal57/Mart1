package com.project.e_mart.dashactivity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.e_mart.R;

public class Login extends AppCompatActivity {

    TextView signupTxt;
    FirebaseAuth mAuth;
    Button btnLog;
    EditText lo_email,lo_pass;
    ImageButton showBtn;
    boolean visible = false;
    SharedPreferences sharedPreferences;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        btnLog = findViewById(R.id.btnLogin);
        showBtn = findViewById(R.id.showBtn);
        lo_email = findViewById(R.id.lo_email);
        lo_pass = findViewById(R.id.lo_pass);
        signupTxt = findViewById(R.id.signup);
        progressBar = findViewById(R.id.progressBar);
        
        sharedPreferences = getSharedPreferences("E-Mart",MODE_PRIVATE);


        signupTxt.setOnClickListener(v ->{

            Intent intent = new Intent(Login.this,Signup.class);
            startActivity(intent);
            finish();
        });

        btnLog.setOnClickListener(v -> {

            progressBar.setVisibility(View.VISIBLE);
            if(validation())
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLogin",true);
                editor.apply();

                Intent intent= new Intent(Login.this, MainActivity2.class);
                Toast.makeText(this,"LogIn Succesful",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        showBtn.setOnClickListener(v -> {
            if(visible){
                lo_pass.setTransformationMethod(new PasswordTransformationMethod());
                showBtn.setImageResource(R.drawable.hide);
                visible=false;
            }
            else{
                lo_pass.setTransformationMethod(null);
                showBtn.setImageResource(R.drawable.visible);
                visible=true;
            }
        });

    }
    private boolean validation() {
        String email, pass;
        email = lo_email.getText().toString();
        pass = lo_pass.getText().toString();

        String s_email,s_pass;
        s_email = sharedPreferences.getString("email","");
        s_pass = sharedPreferences.getString("password","");

        if(email.isEmpty())
        {
            Toast.makeText(this,"E-Mail is required",Toast.LENGTH_SHORT).show();
            lo_email.setError("E-Mail is required");
            return false;
        }
        else if(pass.isEmpty())
        {
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show();
            lo_pass.setError("Password is required");
            return false;
        }
        else if (pass.length()<8) {
            Toast.makeText(this, "Your Password must be of 8 characters", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(email.equals(s_email))) {
            Toast.makeText(this,"E-Mail is Wrong!",Toast.LENGTH_SHORT).show();
            lo_email.setError("E-Mail is Wrong!");
            return false;
        }
         else if (!(pass.equals(s_pass))) {
        Toast.makeText(this,"Password is Incorrect!",Toast.LENGTH_SHORT).show();
        lo_pass.setError("Password is Incorrect!");
        return false;
    }
        mAuth.signInWithEmailAndPassword(s_email, s_pass)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
progressBar.setVisibility(View.GONE);
                        } else {
                            // If sign in fails, display a message to the user.

                        }
                    }
                });
        return true;
    }
}