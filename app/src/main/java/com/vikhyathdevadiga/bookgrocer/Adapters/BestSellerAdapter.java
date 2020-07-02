package com.vikhyathdevadiga.bookgrocer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vikhyathdevadiga.bookgrocer.Product;
import com.vikhyathdevadiga.bookgrocer.R;

import java.util.ArrayList;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.FeaturedViewHolder> {

    public ArrayList<Product> contentList;
    private OnSingleItemClicked listener;
    Context context;

    public BestSellerAdapter(ArrayList<Product> contentList, OnSingleItemClicked listener, Context context) {
        this.contentList = contentList;
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_seller_card, parent, false);
        FeaturedViewHolder holder = new FeaturedViewHolder(view, listener);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        Product product = contentList.get(position);
        holder.product_title.setText(product.getProduct_title());
        holder.product_author.setText(product.getProduct_author());
        holder.product_image.setImageResource(product.getProduct_image());
        holder.product_rating.setRating(product.getProduct_rating());
    }
    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView product_image;
        TextView product_title, product_author;
        RatingBar product_rating;

        OnSingleItemClicked listener;
        public FeaturedViewHolder(@NonNull View itemView, OnSingleItemClicked listener) {
            super(itemView);
            product_image = itemView.findViewById(R.id.best_product_img);
            product_title = itemView.findViewById(R.id.best_product_title);
            product_author = itemView.findViewById(R.id.best_product_author);
            product_rating = itemView.findViewById(R.id.best_product_rating);
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
