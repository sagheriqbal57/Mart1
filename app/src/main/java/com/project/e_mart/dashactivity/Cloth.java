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
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class Cloth extends AppCompatActivity {
    ImageView backBtn;
    private RecyclerView recyclerViewMore;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);

        searchView = findViewById(R.id.searchBtn);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((ClothAdapter)recyclerViewMore.getAdapter()).filter(newText);
                return false;
            }
        });
        initView();
        initRecyclerView();
        bottomNavigation();

        backBtn.setOnClickListener(v -> {
            Intent intent= new Intent(Cloth.this, MainActivity2.class);
            startActivity(intent);
            finish();
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

        homeBtn.setOnClickListener(v -> startActivity(new Intent(Cloth.this,MainActivity2.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(Cloth.this,CartActivity.class)));

        profileBtn.setOnClickListener(v -> startActivity(new Intent(Cloth.this, Profile.class)));
    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items2 = new ArrayList<>();
        items2.add(new PopularDomain("T-shirt Black","A black shirt embodies timeless sophistication and versatility.\n" +
                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
                "suitable for various occasions. Whether paired with formal attire for a\n" +
                " professional setting or dressed down for a casual chic style, the black \n" +
                "shirt effortlessly adds an air of refinement.","item_10",15,5,99));
        items2.add(new PopularDomain("White T Shirt",
                " A blank canvas, a cotton whisper, the white T-shirt beckons\n" +
                " creativity. Its crisp neutrality cradles bold prints or \n" +
                "embraces quiet comfort, a chameleon chameleon, ready to transform \n" +
                "with every whim.","white_t_shirt",42,20,80));
        items2.add(new PopularDomain("Brown Jeans Pant","Whether straight-leg, skinny, or cropped, brown jeans become a canvas \n" +
                "  for your personal style, ready for any adventure.\n" +
                "Rich, earthy brown jeans add a touch of warmth \n" +
                "  and sophistication to any outfit. Their versatility\n" +
                " shines, effortlessly transitioning from laid-back chic with\n" +
                " a crisp white tee to polished cool paired with a camel blazer.","brown_pant",20,10,99));
        items2.add(new PopularDomain("Blue Track","A classic and comfortable choice, the blue tracksuit is a versatile\n" +
                "  piece that can be dressed up or down. The rich\n" +
                " hue flatters any skin tone, while the relaxed fit makes it perfect\n" +
                "  for lounging or running errands. Pair it with white sneakers\n" +
                "  for a sporty look, or dress it up with heels and a statement\n" +
                " necklace for a night out. ","tracksuit",12,4,115));

        recyclerViewMore = findViewById(R.id.moreview);
        recyclerViewMore.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerView.Adapter adapterMore = new ClothAdapter(items2);
        recyclerViewMore.setAdapter(adapterMore);

    }
}