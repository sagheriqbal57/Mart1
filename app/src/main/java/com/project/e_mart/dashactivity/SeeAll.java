package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.project.e_mart.Adapter.AllAdapter;
import com.project.e_mart.Adapter.SeeAllAdapter;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class SeeAll extends AppCompatActivity {

    ImageView backBtn;
    private RecyclerView recyclerViewMore;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);
     searchView = findViewById(R.id.searchBtn);

    startSearch();

    initView();
    initRecyclerView();
    bottomNavigation();

        backBtn.setOnClickListener(v -> {
        Intent intent= new Intent(SeeAll.this, MainActivity2.class);
        startActivity(intent);
        finish();
    });

}
    private void startSearch() {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((AllAdapter)recyclerViewMore.getAdapter()).filter(newText);
                return false;
            }
        });
    }

    private void initView()
    {
        backBtn = findViewById(R.id.backBtn);
    }
    private void bottomNavigation()
    {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(SeeAll.this,MainActivity2.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(SeeAll.this,CartActivity.class)));

        profileBtn.setOnClickListener(v -> startActivity(new Intent(SeeAll.this, Profile.class)));
    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items5 = new ArrayList<>();
        items5.add(new PopularDomain("T-shirt Black","A black shirt embodies timeless sophistication and versatility.\n" +
                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
                "suitable for various occasions. Whether paired with formal attire for a\n" +
                " professional setting or dressed down for a casual chic style, the black \n" +
                "shirt effortlessly adds an air of refinement.","item_10",15,5,99));
        items5.add(new PopularDomain("Smart Watch","A smartwatch is the ultimate fusion of convenience and technology,\n" +
                " a wearable marvel that transcends timekeeping. Seamlessly integrating into your lifestyle, \n" +
                "it offers a myriad of functionalities beyond telling time, from fitness tracking to notifications\n" +
                "and even acting as a mini-computer on your wrist.","item_1",42,20,80));
        items5.add(new PopularDomain("Ring Jewellery",
                " This photo shows two wedding rings made of gold resting next to each other.\n" +
                        " The rings are simple bands, without any embellishments or diamonds.\n\n" +
                        "They sit on a soft, textured surface, which could be velvet or fabric.\n\n" +
                        "The rings are a classic symbol of love and commitment.\n","rings",42,20,80));
        items5.add(new PopularDomain("Sterling Silver Necklace","This necklace features a heart-shaped pendant made of polished \n" +
                "  sterling silver. The pendant has an openwork design with a cutout in\n" +
                "he center, creating a sense of lightness and dimension.\n" +
                "It hangs from a delicate cable chain, also made of sterling silver.\n\n" +
                " This necklace is a versatile piece that can be dressed up or down\n" +
                " making it a great choice for everyday wear or special occasions.\n"
                ,"necklace",20,10,99));
        items5.add(new PopularDomain("i-Phone 14 Pro","The iPhone 14 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","item_2",20,10,1500));
        items5.add(new PopularDomain("VisionX Pro LED TV","The NEXAR 42-inch LED Full HD (FHD) TV is a sleek entertainment powerhouse\n" +
                " designed to elevate your viewing experience. With its impressive 1080p\n" +
                " resolution, vibrant colors, and sharp image quality, it brings your\n" +
                " favorite movies, shows, and games to life. Its expansive 42-inch display\n" +
                " coupled with advanced LED technology offers immersive visuals, while its\n" +
                " sleek design complements any living space seamlessly. ","item_4",12,4,4000));

        recyclerViewMore = findViewById(R.id.moreview);
        recyclerViewMore.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerView.Adapter adapterMore = new SeeAllAdapter(items5);
        recyclerViewMore.setAdapter(adapterMore);

    }



}