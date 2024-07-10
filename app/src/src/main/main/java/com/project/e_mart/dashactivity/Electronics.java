package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.project.e_mart.Adapter.ElectronicsAdapter;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class Electronics extends AppCompatActivity {
    ImageView backBtn,cartImg;
    private RecyclerView recyclerViewMore;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        searchView = findViewById(R.id.searchBtn);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((ElectronicsAdapter)recyclerViewMore.getAdapter()).filter(newText);
                return false;
            }
        });
        initView();
        initRecyclerView();
        bottomNavigation();

        backBtn.setOnClickListener(v -> {
            Intent intent= new Intent(Electronics.this, MainActivity2.class);
            startActivity(intent);
            finish();
        });

        cartImg.setOnClickListener(v -> {
            Intent intent= new Intent(Electronics.this, CartActivity.class);
            startActivity(intent);
            finish();
        });
    }


    private void initView()
    {
        backBtn = findViewById(R.id.backBtn);
        cartImg = findViewById(R.id.cartBtn2);

    }
    private void bottomNavigation()
    {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout wishlistBtn = findViewById(R.id.wishlistBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(Electronics.this,MainActivity2.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(Electronics.this,CartActivity.class)));

        profileBtn.setOnClickListener(v -> startActivity(new Intent(Electronics.this, Profile.class)));

        wishlistBtn.setOnClickListener(v -> startActivity(new Intent(Electronics.this, Wishlist.class)));
    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items3 = new ArrayList<>();
        items3.add(new PopularDomain("iPhone 12 Green","The iPhone 12 green epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","i_phone_12_green",15,5,99));
        items3.add(new PopularDomain("iPhone 12 Pro","The iPhone 12 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","i_phone_12_pro",42,20,80));
        items3.add(new PopularDomain("VisionX Pro LED TV","The NEXAR 42-inch LED Full HD (FHD) TV is a sleek entertainment powerhouse\n" +
                " designed to elevate your viewing experience. With its impressive 1080p\n" +
                " resolution, vibrant colors, and sharp image quality, it brings your\n" +
                " favorite movies, shows, and games to life. Its expansive 42-inch display\n" +
                " coupled with advanced LED technology offers immersive visuals, while its\n" +
                " sleek design complements any living space seamlessly. ","item_4",12,4,4000));
        items3.add(new PopularDomain("Smart Watch","A smartwatch is the ultimate fusion of convenience and technology,\n" +
                " a wearable marvel that transcends timekeeping. Seamlessly integrating into your lifestyle, \n" +
                "it offers a myriad of functionalities beyond telling time, from fitness tracking to notifications\n" +
                "and even acting as a mini-computer on your wrist.","item_2",20,10,1500));
        items3.add(new PopularDomain("iPhone 12 White","The iPhone 14 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","i_phone_12_white",12,4,4000));

        recyclerViewMore = findViewById(R.id.moreview);
        recyclerViewMore.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerView.Adapter adapterMore = new ElectronicsAdapter(items3);
        recyclerViewMore.setAdapter(adapterMore);

    }
}