package com.project.e_mart.dashactivity;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.e_mart.Adapter.CartAdapter;
import com.project.e_mart.Helper.ManagementCart;
import com.project.e_mart.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagementCart managementCart;

    private TextView emptyTxt,totalTxt,subtotalTxt,taxTxt,deliveryTxt,payment_text;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn,cashNext;

    private String pay_method;
   AppCompatButton button2;

   Button pay;
   LinearLayout linearLayout;
   ConstraintLayout cashTi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        pay_method = intent.getStringExtra("text");
        payment_text = findViewById(R.id.payment_text);

        if (pay_method != null && !pay_method.isEmpty()) {
            payment_text.setText(pay_method);
        } else {
            payment_text.setText("Select Payment Method");
        }

        cashNext = findViewById(R.id.CashNext);
        cashTi = findViewById(R.id.payConst);
        button2 = findViewById(R.id.orderBtn);
        managementCart = new ManagementCart(this);

        initView();
        setVariable();
        calculatorCart();
        initList();


        cashTi.setOnClickListener(v -> {
            Intent i = new Intent(CartActivity.this, PaymentMethod.class);
            i.putExtra("price", totalTxt.getText().toString());
            startActivity(i);
        });
        cashNext.setOnClickListener(v ->{
            Intent i = new Intent(CartActivity.this, PaymentMethod.class);
            i.putExtra("price", totalTxt.getText().toString());
            startActivity(i);

        });
        button2.setOnClickListener(v -> {
           if(pay_method.equals("JazzCash"))
            {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "BottomSheetDialog");
            } else if (pay_method.equals("EasyPaisa")) {

               EasyPaisaBottomSheet bottomSheet = new EasyPaisaBottomSheet();
               bottomSheet.show(getSupportFragmentManager(), "BottomSheetDialog");

            } else if (pay_method.equals("Cash On Delivery")) {

                Toast.makeText(this,"Your Order is being Processing\n " +
                        "Confirmation Message will come soon",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(CartActivity.this,MainActivity2.class);
            } else if (pay_method.equals("Credit Card")) {

               CreditCardBottomSheet bottomSheet = new CreditCardBottomSheet();
               bottomSheet.show(getSupportFragmentManager(), "BottomSheetDialog");

            }
           else{

               Toast.makeText(this,"Please Select Payment Method",Toast.LENGTH_SHORT).show();
           }

        });
    }


    private void initList()
    {
        if(managementCart.getListCart().isEmpty())
        {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }
        else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new CartAdapter(managementCart.getListCart(), this, () -> calculatorCart());
        recyclerView.setAdapter(adapter);

    }
    private void calculatorCart()
    {
    double percentTax =0.04;
    double delivery=10;
    tax = Math.round(managementCart.getTotalFee()*percentTax*100.0)/100.0;

    double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
    double itemTotal = Math.round(managementCart.getTotalFee()*100)/100;

    subtotalTxt.setText("$"+itemTotal);
    deliveryTxt.setText("$"+delivery);
    taxTxt.setText("$"+tax);
    totalTxt.setText("$"+total);
    }
    private void setVariable()
    {
    backBtn.setOnClickListener(v -> finish());
    }
    private void initView()
    {
        subtotalTxt = findViewById(R.id.subtotalTxt);
        totalTxt = findViewById(R.id.totalTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        recyclerView = findViewById(R.id.view2);
        scrollView = findViewById(R.id.scrollView2);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt= findViewById(R.id.emptyTxt);
    }


    public void setManagementCart(ManagementCart managementCart) {
        this.managementCart = managementCart;
    }


}