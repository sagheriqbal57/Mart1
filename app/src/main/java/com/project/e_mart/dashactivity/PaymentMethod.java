package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.e_mart.R;

public class PaymentMethod extends AppCompatActivity {

    TextView totalTxt,jazz,easy,credit,cash;
    Boolean flag = true;
    Button payBtn;

    ImageView backBtn;
    LinearLayout jazz_cash_layout,easy_paisa_layout,credit_layout,cash_on_delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        jazz = findViewById(R.id.jazz_txt);
        easy = findViewById(R.id.easy_txt);
        credit = findViewById(R.id.credit_txt);
        cash = findViewById(R.id.cash_txt);

        backBtn = findViewById(R.id.backBtn);
        jazz_cash_layout = findViewById(R.id.jazzcashlayout);
        easy_paisa_layout = findViewById(R.id.easypaisalayout);
        credit_layout = findViewById(R.id.creditlayout);
        cash_on_delivery = findViewById(R.id.cash);

        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        totalTxt = findViewById(R.id.totalTxt);
        totalTxt.setText(price);

        payBtn = findViewById(R.id.confirmBtn);

        backBtn.setOnClickListener(v -> startActivity(new Intent(PaymentMethod.this,CartActivity.class)));


        cash_on_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cash_on_delivery.setSelected(!cash_on_delivery.isSelected());
                if(easy_paisa_layout.isSelected())
                {
                    easy_paisa_layout.setSelected(!easy_paisa_layout.isSelected());
                }
                if(credit_layout.isSelected() ){
                    credit_layout.setSelected(!credit_layout.isSelected());
                }
                if(jazz_cash_layout.isSelected() ){
                    jazz_cash_layout.setSelected(!jazz_cash_layout.isSelected());
                }
            }
        });
        jazz_cash_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jazz_cash_layout.setSelected(!jazz_cash_layout.isSelected());
                if(cash_on_delivery.isSelected())
                {
                    cash_on_delivery.setSelected(!cash_on_delivery.isSelected());
                }
                if(easy_paisa_layout.isSelected())
                {
                    easy_paisa_layout.setSelected(!easy_paisa_layout.isSelected());
                }
                if(credit_layout.isSelected() ){
                    credit_layout.setSelected(!credit_layout.isSelected());
                }
            }
        });
        easy_paisa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easy_paisa_layout.setSelected(!easy_paisa_layout.isSelected());
                if(cash_on_delivery.isSelected())
                {
                    cash_on_delivery.setSelected(!cash_on_delivery.isSelected());
                }
                if(jazz_cash_layout.isSelected() ){
                    jazz_cash_layout.setSelected(!jazz_cash_layout.isSelected());
                }
                if(credit_layout.isSelected() ){
                    credit_layout.setSelected(!credit_layout.isSelected());
                }
            }
        });
        credit_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit_layout.setSelected(!credit_layout.isSelected());
                if(cash_on_delivery.isSelected())
                {
                    cash_on_delivery.setSelected(!cash_on_delivery.isSelected());
                }
                if(easy_paisa_layout.isSelected())
                {
                    easy_paisa_layout.setSelected(!easy_paisa_layout.isSelected());
                }
                if(jazz_cash_layout.isSelected() ){
                    jazz_cash_layout.setSelected(!jazz_cash_layout.isSelected());
                }
            }
        });
        payBtn.setOnClickListener(v -> {

            if (jazz_cash_layout.isSelected()) {

                Intent i = new Intent(PaymentMethod.this, CartActivity.class);
                i.putExtra("text", jazz.getText().toString());
                Toast.makeText(this,"JazzCash Selected",Toast.LENGTH_SHORT).show();
                startActivity(i);
            } else if (credit_layout.isSelected()) {
                Intent i = new Intent(PaymentMethod.this, CartActivity.class);
                i.putExtra("text", credit.getText().toString());
                Toast.makeText(this,"Credit Card Selected",Toast.LENGTH_SHORT).show();
                startActivity(i);
            } else if (easy_paisa_layout.isSelected()) {
                Intent i = new Intent(PaymentMethod.this, CartActivity.class);
                i.putExtra("text", easy.getText().toString());
                Toast.makeText(this,"EasyPaisa Selected",Toast.LENGTH_SHORT).show();
                startActivity(i);
            } else if (cash_on_delivery.isSelected()) {
                Intent i = new Intent(PaymentMethod.this, CartActivity.class);
                i.putExtra("text", cash.getText().toString());
                Toast.makeText(this,"Cash On Delivery Selected",Toast.LENGTH_SHORT).show();
                startActivity(i);

            } else {
                Toast.makeText(this,"Payment Method Not Selected !",Toast.LENGTH_SHORT).show();
            }

        });

    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Check that it is the SecondActivity with an OK result
//        if (requestCode == 0 && resultCode == RESULT_OK) {
//            // Get String data from Intent
//            String ResponseCode = data.getStringExtra("pp_ResponseCode");
//            System.out.println("DateFn: ResponseCode:" + ResponseCode);
//            if(ResponseCode.equals("000")) {
//                Toast.makeText(getApplicationContext(), "Payment Success", Toast.LENGTH_SHORT).show();
//            }
//            else
//            {
//                Toast.makeText(getApplicationContext(), "Payment Failed", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

}