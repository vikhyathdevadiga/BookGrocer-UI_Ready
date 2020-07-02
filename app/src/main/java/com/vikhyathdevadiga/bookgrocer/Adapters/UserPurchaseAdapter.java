package com.vikhyathdevadiga.bookgrocer.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vikhyathdevadiga.bookgrocer.R;

import java.util.ArrayList;


public class UserPurchaseAdapter extends RecyclerView.Adapter<UserPurchaseAdapter.FeaturedViewHolder> {

    public ArrayList<Integer> contentList;
    private OnSingleItemClicked listener;
    Context context;

    public UserPurchaseAdapter(ArrayList<Integer> contentList, OnSingleItemClicked listener, Context context) {
        this.contentList = contentList;
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_purchase_card, parent, false);
        FeaturedViewHolder holder = new FeaturedViewHolder(view, listener);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        holder.product_image.setImageResource(contentList.get(position));
    }
    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView product_image;

        OnSingleItemClicked listener;
        public FeaturedViewHolder(@NonNull View itemView, OnSingleItemClicked listener) {
            super(itemView);
            product_image = itemView.findViewById(R.id.user_purchased_product_image);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onSingleItemClick(getAdapterPosition(),view);
        }
    }

    public interface OnSingleItemClicked{
        void onSingleItemClick(int position, View view);
    }
}
