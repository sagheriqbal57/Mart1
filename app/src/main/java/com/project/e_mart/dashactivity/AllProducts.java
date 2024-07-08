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
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class AllProducts extends AppCompatActivity {

    ImageView backBtn;
    private RecyclerView recyclerViewMore;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_products);

        searchView = findViewById(R.id.searchBtn);
        searchView.requestFocus();
        startSearch();

        initView();
        initRecyclerView();
        bottomNavigation();

        backBtn.setOnClickListener(v -> {
            Intent intent= new Intent(AllProducts.this, MainActivity2.class);
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

        homeBtn.setOnClickListener(v -> startActivity(new Intent(AllProducts.this,MainActivity2.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(AllProducts.this,CartActivity.class)));

        profileBtn.setOnClickListener(v -> startActivity(new Intent(AllProducts.this, Profile.class)));
    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items4 = new ArrayList<>();
        items4.add(new PopularDomain("T-shirt Black","A black shirt embodies timeless sophistication and versatility.\n" +
                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
                "suitable for various occasions. Whether paired with formal attire for a\n" +
                " professional setting or dressed down for a casual chic style, the black \n" +
                "shirt effortlessly adds an air of refinement.","item_10",15,5,99));
        items4.add(new PopularDomain("Smart Watch","A smartwatch is the ultimate fusion of convenience and technology,\n" +
                " a wearable marvel that transcends timekeeping. Seamlessly integrating into your lifestyle, \n" +
                "it offers a myriad of functionalities beyond telling time, from fitness tracking to notifications\n" +
                "and even acting as a mini-computer on your wrist.","item_1",42,20,80));
        items4.add(new PopularDomain("i-Phone 14 Pro","The iPhone 14 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","item_2",20,10,1500));
        items4.add(new PopularDomain("VisionX Pro LED TV","The NEXAR 42-inch LED Full HD (FHD) TV is a sleek entertainment powerhouse\n" +
                " designed to elevate your viewing experience. With its impressive 1080p\n" +
                " resolution, vibrant colors, and sharp image quality, it brings your\n" +
                " favorite movies, shows, and games to life. Its expansive 42-inch display\n" +
                " coupled with advanced LED technology offers immersive visuals, while its\n" +
                " sleek design complements any living space seamlessly. ","item_4",12,4,4000));

        items4.add(new PopularDomain("White T Shirt",
                " A blank canvas, a cotton whisper, the white T-shirt beckons\n" +
                        " creativity. Its crisp neutrality cradles bold prints or \n" +
                        "embraces quiet comfort, a chameleon chameleon, ready to transform \n" +
                        "with every whim.","white_t_shirt",42,20,80));
        items4.add(new PopularDomain("Brown Jeans Pant","Whether straight-leg, skinny, or cropped, brown jeans become a canvas \n" +
                "  for your personal style, ready for any adventure.\n" +
                "Rich, earthy brown jeans add a touch of warmth \n" +
                "  and sophistication to any outfit. Their versatility\n" +
                " shines, effortlessly transitioning from laid-back chic with\n" +
                " a crisp white tee to polished cool paired with a camel blazer.","brown_pant",20,10,99));
        items4.add(new PopularDomain("Blue Track","A classic and comfortable choice, the blue tracksuit is a versatile\n" +
                "  piece that can be dressed up or down. The rich\n" +
                " hue flatters any skin tone, while the relaxed fit makes it perfect\n" +
                "  for lounging or running errands. Pair it with white sneakers\n" +
                "  for a sporty look, or dress it up with heels and a statement\n" +
                " necklace for a night out. ","tracksuit",12,4,115));
        items4.add(new PopularDomain("iPhone 12 Green","The iPhone 12 green epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","i_phone_12_green",15,5,99));
        items4.add(new PopularDomain("iPhone 12 Pro","The iPhone 12 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","i_phone_12_pro",42,20,80));
        items4.add(new PopularDomain("iPhone 12 White","The iPhone 14 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","i_phone_12_white",12,4,4000));
        items4.add(new PopularDomain("White Wooden Chair","Crisp and bright, the chair stands in stark relief, reflecting light and\n" +
                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
                "suitable for various occasions. Whether paired with formal attire for a\n" +
                " professional setting or dressed down for a casual chic style, the black \n" +
                "shirt effortlessly adds an air of refinement.","chair",15,5,99));
        items4.add(new PopularDomain("Samurai Blade"," the samurai blade is still revered as a symbol of Japanese\n" +
                " culture and history. It is often used in traditional ceremonies and is a popular collector's \n" +
                " item. The samurai blade is also featured in many works of art, literature, and film, and \n" +
                " has become an iconic symbol of Japan around the world.","blade",42,20,80));
        items4.add(new PopularDomain("DeskBell","A touch of class for any desk, this sapphire-hued deskbell is wrapped\n" +
                " in smooth, supple leather. Its gentle chime rings with\n" +
                " a satisfyingly refined tone, a far cry from the harsh jangling of ordinary bells. Whether\n" +
                "gracing the corner of an executive's desk or  perched playfully on a home\n" +
                " office shelf, this bell is sure to add a touch of timeless elegance. \n","desk_bell",20,10,1500));
        items4.add(new PopularDomain("Black Leather BreifCase","A cool confidence emanates from the rich cobalt hue of\n" +
                " this  leather briefcase. Its smooth, supple curves\n" +
                " whisper of polished professionalism, while sturdy seams hint\n" +
                "  at secrets of success locked within. A silent, powerful \n" +
                " companion for the urban warrior.\n","briefcase",12,4,4000));
        items4.add(new PopularDomain("Diamond Necklace","The pendant is a teardrop-shaped diamond set in\n" +
                " a white gold bezel. The chain is also white gold, and it appears to\n " +
                "be a delicate cable chain. The pendant is positioned on a gray velvet or silk \n" +
                "background. The delicate cable chain is also made of white gold, and \n" +
                "it adds a touch of sophistication to the piece.","necklace_d",15,5,99));
        items4.add(new PopularDomain("Ring Jewellery",
                " This photo shows two wedding rings made of gold resting next to each other.\n" +
                        " The rings are simple bands, without any embellishments or diamonds.\n\n" +
                        "They sit on a soft, textured surface, which could be velvet or fabric.\n\n" +
                        "The rings are a classic symbol of love and commitment.\n","rings",42,20,80));
        items4.add(new PopularDomain("Sterling Silver Necklace","This necklace features a heart-shaped pendant made of polished \n" +
                "  sterling silver. The pendant has an openwork design with a cutout in\n" +
                "he center, creating a sense of lightness and dimension.\n" +
                "It hangs from a delicate cable chain, also made of sterling silver.\n\n" +
                " This necklace is a versatile piece that can be dressed up or down\n" +
                " making it a great choice for everyday wear or special occasions.\n"
                ,"necklace",20,10,99));
        items4.add(new PopularDomain("MiniBag","This small, structured bucket bag is crafted from rich, dark brown leather.\n\n" +
                " The bag features a classic drawstring closure with a gold-tone metal ring and tassel.\n\n" +
                " A chunky gold-tone chain strap adds a touch of glamour and can be worn on the shoulder\n" +
                " The bag's compact size makes it perfect for everyday errands or a night out.\n\n" +
                " necklace for a night out. ","mini_bag",12,4,115));



        recyclerViewMore = findViewById(R.id.moreview);
        recyclerViewMore.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerView.Adapter adapterMore = new AllAdapter(items4);
        recyclerViewMore.setAdapter(adapterMore);

    }
}