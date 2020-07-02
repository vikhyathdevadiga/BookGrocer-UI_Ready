package com.vikhyathdevadiga.bookgrocer.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vikhyathdevadiga.bookgrocer.Adapters.UserPurchaseAdapter;
import com.vikhyathdevadiga.bookgrocer.R;

import java.util.ArrayList;

public class UserProfile extends Fragment implements UserPurchaseAdapter.OnSingleItemClicked {

    RecyclerView user_purchase;
    UserPurchaseAdapter adapter;
    private ArrayList<Integer> contentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user_profile, container, false);


        user_purchase = view.findViewById(R.id.user_purchase_recycler);

        user_purchase.setHasFixedSize(true);
        user_purchase.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        contentList.add(R.drawable.purchased_1);
        contentList.add(R.drawable.purchased_2);
        contentList.add(R.drawable.purchased_3);
        contentList.add(R.drawable.purchased_1);
        adapter = new UserPurchaseAdapter(contentList, UserProfile.this, getActivity());
        user_purchase.setAdapter(adapter);
        return view;

    }

    @Override
    public void onSingleItemClick(int position, View view) {

    }
}