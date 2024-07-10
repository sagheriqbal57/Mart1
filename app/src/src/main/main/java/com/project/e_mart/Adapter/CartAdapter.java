package com.project.e_mart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.project.e_mart.Helper.ChangeNumberitemsListener;
import com.project.e_mart.Helper.ManagementCart;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {


    ArrayList<PopularDomain> listItemSelected;
    private ManagementCart managementCart;
    ChangeNumberitemsListener changeNumberitemsListener;

    public CartAdapter(ArrayList<PopularDomain> listItemSelected, Context context,ChangeNumberitemsListener changeNumberitemsListener) {
        this.listItemSelected = listItemSelected;
        managementCart = new ManagementCart(context);
        this.changeNumberitemsListener = changeNumberitemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {

        holder.title.setText(listItemSelected.get(position).getTitle());


        holder.feeEachItem.setText("$"+listItemSelected.get(position).getPrice());
        holder.totalEachItem.setText("$"+Math.round((listItemSelected.get(position).getNumberInCart()*listItemSelected.get(position).getPrice())));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(listItemSelected.get(position).getPicUrl(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.pic);

        holder.plusItem.setOnClickListener(v ->
            managementCart.plusNumberItem(listItemSelected, position, () -> {

                String chr = holder.num.getText().toString();
                int num = Integer.parseInt(chr);
                num++;
                holder.num.setText(String.valueOf(num));
                notifyDataSetChanged();
                changeNumberitemsListener.change();
            }));
            holder.minusItem.setOnClickListener(v1 ->
                    managementCart.minusNumberItem(listItemSelected, position, () -> {
                        String chr = holder.num.getText().toString();
                        int num = Integer.parseInt(chr);
                        num--;
                        holder.num.setText(String.valueOf(num));
                notifyDataSetChanged();
                changeNumberitemsListener.change();
            }));

    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title,feeEachItem,plusItem,minusItem;
        ImageView pic;
        TextView totalEachItem,num;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeTxt);
            plusItem = itemView.findViewById(R.id.plusCartBtn);
            minusItem = itemView.findViewById(R.id.minusCartBtn);
            num = itemView.findViewById(R.id.numberitemsTxt);
            totalEachItem = itemView.findViewById(R.id.totalEachitem);
        }
        }
    }
