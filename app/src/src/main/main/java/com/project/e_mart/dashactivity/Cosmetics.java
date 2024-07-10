package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.project.e_mart.Adapter.ClothAdapter;
import com.project.e_mart.Adapter.CosmeticsAdapter;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class Cosmetics extends AppCompatActivity {
    ImageView backBtn,cartImg;
    private RecyclerView recyclerViewMore;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetics);

        searchView = findViewById(R.id.searchBtn);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((CosmeticsAdapter)recyclerViewMore.getAdapter()).filter(newText);
                return false;
            }
        });
        initView();
        initRecyclerView();
        bottomNavigation();

        backBtn.setOnClickListener(v -> {
            Intent intent= new Intent(Cosmetics.this, MainActivity2.class);
            startActivity(intent);
            finish();
        });

        cartImg.setOnClickListener(v -> {
            Intent intent= new Intent(Cosmetics.this, CartActivity.class);
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

        homeBtn.setOnClickListener(v -> startActivity(new Intent(Cosmetics.this,MainActivity2.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(Cosmetics.this,CartActivity.class)));

        profileBtn.setOnClickListener(v -> startActivity(new Intent(Cosmetics.this, Profile.class)));

        wishlistBtn.setOnClickListener(v -> startActivity(new Intent(Cosmetics.this, Wishlist.class)));

    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items2 = new ArrayList<>();
        items2.add(new PopularDomain("Diamond Necklace","The pendant is a teardrop-shaped diamond set in\n" +
                " a white gold bezel. The chain is also white gold, and it appears to\n " +
                "be a delicate cable chain. The pendant is positioned on a gray velvet or silk \n" +
                "background. The delicate cable chain is also made of white gold, and \n" +
                "it adds a touch of sophistication to the piece.","necklace_d",15,5,99));
        items2.add(new PopularDomain("Ring Jewellery",
                " This photo shows two wedding rings made of gold resting next to each other.\n" +
                        " The rings are simple bands, without any embellishments or diamonds.\n\n" +
                        "They sit on a soft, textured surface, which could be velvet or fabric.\n\n" +
                        "The rings are a classic symbol of love and commitment.\n","rings",42,20,80));
        items2.add(new PopularDomain("Sterling Silver Necklace","This necklace features a heart-shaped pendant made of polished \n" +
                "  sterling silver. The pendant has an openwork design with a cutout in\n" +
                "he center, creating a sense of lightness and dimension.\n" +
                "It hangs from a delicate cable chain, also made of sterling silver.\n\n" +
                " This necklace is a versatile piece that can be dressed up or down\n" +
                " making it a great choice for everyday wear or special occasions.\n"
                ,"necklace",20,10,99));
        items2.add(new PopularDomain("MiniBag","This small, structured bucket bag is crafted from rich, dark brown leather.\n\n" +
                " The bag features a classic drawstring closure with a gold-tone metal ring and tassel.\n\n" +
                " A chunky gold-tone chain strap adds a touch of glamour and can be worn on the shoulder\n" +
                " The bag's compact size makes it perfect for everyday errands or a night out.\n\n" +
                " necklace for a night out. ","mini_bag",12,4,115));

        recyclerViewMore = findViewById(R.id.moreview);
        recyclerViewMore.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerView.Adapter adapterMore;
        adapterMore = new CosmeticsAdapter(items2);
        recyclerViewMore.setAdapter(adapterMore);

    }
}