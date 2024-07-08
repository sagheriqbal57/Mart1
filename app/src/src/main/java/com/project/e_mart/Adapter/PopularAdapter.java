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

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {

    ArrayList<PopularDomain> items;
    Context context;

//    public void updateData(ArrayList<PopularDomain> updatedItems) {
//        this.items.clear();
//        this.items.addAll(updatedItems);
//        notifyDataSetChanged();
//    }
    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pup_list, parent, false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.feeTxt.setText("$" + items.get(position).getPrice());
        holder.score.setText("" + items.get(position).getScore());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).
                load(drawableResourceId).transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.pic);

        holder.layoutItem.setOnClickListener(v -> {

            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);

            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return  items.size();
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