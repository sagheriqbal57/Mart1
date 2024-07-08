package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.e_mart.R;

public class ChangePassword extends AppCompatActivity {
    ImageButton showBtn,showBtn_c;

    ImageView backBtn;
    EditText pass,c_pass;
    boolean visible = false;
    
    Button changeBtn;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        sharedPreferences = getSharedPreferences("E-Mart",MODE_PRIVATE);
        String p_pass = sharedPreferences.getString("password","");

        backBtn = findViewById(R.id.backBtn1);
        changeBtn = findViewById(R.id.btnChange);
        showBtn = findViewById(R.id.showBtn);
        showBtn_c = findViewById(R.id.showBtnc);
        pass = findViewById(R.id.new_pass);
        c_pass = findViewById(R.id.new_confirm);


        backBtn.setOnClickListener(v -> startActivity(new Intent(ChangePassword.this, Profile.class)));
        showBtn.setOnClickListener(v -> {
            if(visible){
                pass.setTransformationMethod(new PasswordTransformationMethod());
                showBtn.setImageResource(R.drawable.hide);
                visible=false;
            }
            else{
                pass.setTransformationMethod(null);
                showBtn.setImageResource(R.drawable.visible);
                visible=true;
            }
        });

        showBtn_c.setOnClickListener(v -> {
            if(visible){
                c_pass.setTransformationMethod(new PasswordTransformationMethod());
                showBtn_c.setImageResource(R.drawable.hide);
                visible=false;
            }
            else{
                c_pass.setTransformationMethod(null);
                showBtn_c.setImageResource(R.drawable.visible);
                visible=true;
            }
        });
        
        
        changeBtn.setOnClickListener(v -> {


            if (validation()) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("password",pass.getText().toString());
                editor.apply();

                Toast.makeText(this,"Password Changed Successfully",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(ChangePassword.this, Profile.class);
                //intent.putExtra("name",su_name.getText().toString());
                startActivity(intent);
                finish();

            }

        });
    }
    private boolean validation() {
        String  n_pass , c_n_pass;
        n_pass = pass.getText().toString();
        c_n_pass = c_pass.getText().toString();

         if(n_pass.isEmpty())
        {
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show();
            pass.setError("Password is required");
            return false;
        }
        else if(c_n_pass.isEmpty())
        {
            Toast.makeText(this,"Please Confirm Password",Toast.LENGTH_SHORT).show();
            c_pass.setError("Confirm Password is required");
            return false;
        } else if (n_pass.length()<8) {
            Toast.makeText(this,"Your Password must be of 8 characters",Toast.LENGTH_SHORT).show();
            return false;
        } else if (!n_pass.equals(c_n_pass)) {
            Toast.makeText(this,"Password & Confirm Password are not same !",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}