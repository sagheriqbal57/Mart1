package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.project.e_mart.Adapter.ToolsAdapter;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class Tools extends AppCompatActivity {
    ImageView backBtn,cartImg;
    private RecyclerView recyclerViewMore;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        searchView = findViewById(R.id.searchBtn);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((ToolsAdapter)recyclerViewMore.getAdapter()).filter(newText);
                return false;
            }
        });
        initView();
        initRecyclerView();
        bottomNavigation();

        backBtn.setOnClickListener(v -> {
            Intent intent= new Intent(Tools.this, MainActivity2.class);
            startActivity(intent);
            finish();
        });

        cartImg.setOnClickListener(v -> {
            Intent intent= new Intent(Tools.this, CartActivity.class);
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


        homeBtn.setOnClickListener(v -> startActivity(new Intent(Tools.this,MainActivity2.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(Tools.this,CartActivity.class)));

        profileBtn.setOnClickListener(v -> startActivity(new Intent(Tools.this, Profile.class)));
        wishlistBtn.setOnClickListener(v -> startActivity(new Intent(Tools.this, Wishlist.class)));

    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items6 = new ArrayList<>();
        items6.add(new PopularDomain("White Wooden Chair","Crisp and bright, the chair stands in stark relief, reflecting light and\n" +
                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
                "suitable for various occasions. Whether paired with formal attire for a\n" +
                " professional setting or dressed down for a casual chic style, the black \n" +
                "shirt effortlessly adds an air of refinement.","chair",15,5,99));
        items6.add(new PopularDomain("Samurai Blade"," the samurai blade is still revered as a symbol of Japanese\n" +
                " culture and history. It is often used in traditional ceremonies and is a popular collector's \n" +
                " item. The samurai blade is also featured in many works of art, literature, and film, and \n" +
                " has become an iconic symbol of Japan around the world.","blade",42,20,80));
        items6.add(new PopularDomain("DeskBell","A touch of class for any desk, this sapphire-hued deskbell is wrapped\n" +
                " in smooth, supple leather. Its gentle chime rings with\n" +
                " a satisfyingly refined tone, a far cry from the harsh jangling of ordinary bells. Whether\n" +
                "gracing the corner of an executive's desk or  perched playfully on a home\n" +
                " office shelf, this bell is sure to add a touch of timeless elegance. \n","desk_bell",20,10,1500));
        items6.add(new PopularDomain("Black Leather BreifCase","A cool confidence emanates from the rich cobalt hue of\n" +
                " this  leather briefcase. Its smooth, supple curves\n" +
                " whisper of polished professionalism, while sturdy seams hint\n" +
                "  at secrets of success locked within. A silent, powerful \n" +
                " companion for the urban warrior.\n","briefcase",12,4,4000));

        recyclerViewMore = findViewById(R.id.moreview);
        recyclerViewMore.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerView.Adapter adapterMore = new ToolsAdapter(items6);
        recyclerViewMore.setAdapter(adapterMore);

    }
}