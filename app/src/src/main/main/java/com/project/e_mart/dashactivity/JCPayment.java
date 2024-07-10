package com.project.e_mart.dashactivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.e_mart.R;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JCPayment extends AppCompatActivity {

TextView number_txt;
Button pay_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jcpayment);

        pay_btn = findViewById(R.id.btnPay);
        number_txt = findViewById(R.id.number_txt);


        pay_btn.setOnClickListener(v -> {

            Toast.makeText(this,"Payment Done",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(JCPayment.this, MainActivity2.class);
            startActivity(i);
            finish();
        });

    }
}