package com.project.e_mart.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.project.e_mart.R;
import com.project.e_mart.dashactivity.DetailActivity;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class SeeAllAdapter extends RecyclerView.Adapter<SeeAllAdapter.Viewholder>{
    ArrayList<PopularDomain> items5;
    private ArrayList<PopularDomain> itemsFiltered;
    Context context;

    //    public void updateData(ArrayList<PopularDomain> updatedItems) {
//        this.items.clear();
//        this.items.addAll(updatedItems);
//        notifyDataSetChanged();
//    }
    public SeeAllAdapter(ArrayList<PopularDomain> items5) {
        this.items5 = items5;
        this.itemsFiltered = items5;
    }

    public void filter(String query) {
        query = query.toLowerCase();
        itemsFiltered.clear();

        for (PopularDomain item : items5) {
            if (item.getTitle().toLowerCase().contains(query)) {
                itemsFiltered.add(item);
            }
        }

        notifyDataSetChanged(); // Notify adapter of data change
    }
    @NonNull
    @Override
    public SeeAllAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pup_list, parent, false);
        return new SeeAllAdapter.Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAllAdapter.Viewholder holder, int position) {
        holder.titleTxt.setText(items5.get(position).getTitle());
        holder.feeTxt.setText("$" + items5.get(position).getPrice());
        holder.score.setText("" + items5.get(position).getScore());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items5.get(position).getPicUrl(),
                "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).
                load(drawableResourceId).transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.pic);

        holder.layoutItem.setOnClickListener(v -> {

            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items5.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return  items5.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt, feeTxt, score;
        ConstraintLayout layoutItem;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.titleTxt);
            score = itemView.findViewById(R.id.scoreTxt);
            feeTxt = itemView.findViewById(R.id.feeTxt);
            pic = itemView.findViewById(R.id.pic);
            layoutItem = itemView.findViewById(R.id.layout_item);
        }
    }
}
