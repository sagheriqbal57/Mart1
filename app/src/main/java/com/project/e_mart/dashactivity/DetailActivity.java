package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.e_mart.Helper.ManagementCart;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

public class DetailActivity extends AppCompatActivity {

    private Button addToCartBtn;
    private TextView titleTxt, feeTxt ,descriptionTxt, reviewTxt ,scoreTxt;

    private ImageView picItem , backBtn;

    private PopularDomain object;

    private int numberOrder = 1;

    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle(){


        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());

        Glide.with(this).load(drawableResourceId).into(picItem);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        scoreTxt.setText(object.getScore()+"");
        reviewTxt.setText(object.getReview()+"");

       addToCartBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               object.setNumberInCart(numberOrder);
               managementCart.insertFood(object);
           }
       });

        backBtn.setOnClickListener(v -> finish());
    }
    private void initView()
    {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.feeTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        picItem = findViewById(R.id.itemPic);
        backBtn = findViewById(R.id.backBtn);


    }
//    private void updateAdapterWithData() {
//        // Fetch or update your data
//        ArrayList<PopularDomain> updateditems = new ArrayList<>();
//        updateditems.add(new PopularDomain("T-shirt Black","A black shirt embodies timeless sophistication and versatility.\n" +
//                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
//                "suitable for various occasions. Whether paired with formal attire for a\n" +
//                " professional setting or dressed down for a casual chic style, the black \n" +
//                "shirt effortlessly adds an air of refinement.","item_1",15,5,99));
//        updateditems.add(new PopularDomain("Smart Watch","A smartwatch is the ultimate fusion of convenience and technology,\n" +
//                " a wearable marvel that transcends timekeeping. Seamlessly integrating into your lifestyle, \n" +
//                "it offers a myriad of functionalities beyond telling time, from fitness tracking to notifications\n" +
//                "and even acting as a mini-computer on your wrist.","item_2",42,20,80));
//        updateditems.add(new PopularDomain("i-Phone 14 Pro","The iPhone 14 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
//                " Its cutting-edge technology, paired with an elegant design,\n" +
//                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
//                " Super Retina XDR display and an advanced camera system that captures\n" +
//                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","item_3",20,10,1500));
//        updateditems.add(new PopularDomain("VisionX Pro LED TV","The NEXAR 42-inch LED Full HD (FHD) TV is a sleek entertainment powerhouse\n" +
//                " designed to elevate your viewing experience. With its impressive 1080p\n" +
//                " resolution, vibrant colors, and sharp image quality, it brings your\n" +
//                " favorite movies, shows, and games to life. Its expansive 42-inch display\n" +
//                " coupled with advanced LED technology offers immersive visuals, while its\n" +
//                " sleek design complements any living space seamlessly. ","item_4",12,4,4000));
//
//        // Update the adapter's dataset
//        PopularAdapter PopularAdapter = null;
//       // PopularAdapter.updateData(updateditems);
//    }
}
