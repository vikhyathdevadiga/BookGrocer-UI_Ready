package com.vikhyathdevadiga.bookgrocer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vikhyathdevadiga.bookgrocer.Adapters.BestSellerAdapter;
import com.vikhyathdevadiga.bookgrocer.Adapters.RecyclerAdapter;
import com.vikhyathdevadiga.bookgrocer.Product;
import com.vikhyathdevadiga.bookgrocer.R;

import java.util.ArrayList;

import static com.vikhyathdevadiga.bookgrocer.HomePage.drawerLayout;

public class HomeFragment extends Fragment implements RecyclerAdapter.OnSingleItemClicked, BestSellerAdapter.OnSingleItemClicked{

    RecyclerView top_pics, recently_viewed, best_seller;
    RecyclerAdapter top_pics_adapter, recently_played_Adapter;
    BestSellerAdapter best_Seller_Adapter;
    private ArrayList<Product> top_pics_list = new ArrayList<>();
    private ArrayList<Product> recent_list = new ArrayList<>();
    private ArrayList<Product> best_list = new ArrayList<>();
    ImageButton menuIcon;




    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        top_pics = view.findViewById(R.id.recycler_top_pics);
        recently_viewed = view.findViewById(R.id.recycler_Recently_viewed);
        best_seller = view.findViewById(R.id.recycler_best_sellers);
        menuIcon = view.findViewById(R.id.menu_icon);

        top_pics.setHasFixedSize(true);
        top_pics.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        top_pics_list.add(new Product(R.drawable.top_pics_1, "The Dissapearance of Emila Zola", "Michael Rosen"));
        top_pics_list.add(new Product(R.drawable.top_pics_2, "Fatherhood", "Marcus Berkmann"));
        top_pics_list.add(new Product(R.drawable.top_pics_3, "The Time Travellers Handbook", "Stride Lottie"));

        top_pics_adapter = new RecyclerAdapter(top_pics_list, HomeFragment.this, getActivity());
        top_pics.setAdapter(top_pics_adapter);

        recently_viewed.setHasFixedSize(true);
        recently_viewed.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        recent_list.add(new Product(R.drawable.recent_1, "The Dissapearance of Emila Zola", "Michael Rosen"));
        recent_list.add(new Product(R.drawable.recent_2, "Fatherhood", "Marcus Berkmann"));
        recent_list.add(new Product(R.drawable.recent_3, "The Time Travellers Handbook", "Stride Lottie"));

        recently_played_Adapter = new RecyclerAdapter(recent_list, HomeFragment.this, getActivity());
        recently_viewed.setAdapter(recently_played_Adapter);

        best_seller.setHasFixedSize(true);
        best_seller.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        best_list.add(new Product(R.drawable.best_1,3, "The Dissapearance of Emila Zola", "Michael Rosen"));
        best_list.add(new Product(R.drawable.best_2,5, "Fatherhood", "Marcus Berkmann"));
        best_list.add(new Product(R.drawable.best_3,4, "The Time Travellers Handbook", "Stride Lottie"));

        best_Seller_Adapter = new BestSellerAdapter(best_list, HomeFragment.this, getActivity());
        best_seller.setAdapter(best_Seller_Adapter);

        menuIcon.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.END))
                    drawerLayout.closeDrawer(GravityCompat.END);
                else drawerLayout.openDrawer(GravityCompat.END);
            }
        });
        return view;
    }

    @Override
    public void onSingleItemClick(int position, View view) {

    }
}
