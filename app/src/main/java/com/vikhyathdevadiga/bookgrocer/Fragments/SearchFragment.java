package com.vikhyathdevadiga.bookgrocer.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.vikhyathdevadiga.bookgrocer.R;
import com.vikhyathdevadiga.bookgrocer.Results;

public class SearchFragment extends Fragment {

    ViewPager pager;

    GridView gridView;
    String[] branches = {"Biography", "Business", "Children", "Cookery", "Fiction", "Graphic Novels"};
    int[] images = {R.drawable.grid_product_1, R.drawable.grid_product_2, R.drawable.grid_product_3, R.drawable.grid_product_4, R.drawable.grid_product_5, R.drawable.grid_product_6};
    int[] backgrounds = {R.drawable.rectangle_1, R.drawable.rectangle_2, R.drawable.rectangle_3, R.drawable.rectangle_4, R.drawable.rectangle_5, R.drawable.rectangle_6};
    BottomSheetBehavior behavior;
    ImageButton filter;
    Button cancel_btn;
    private EditText edt_search;
    TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        filter = view.findViewById(R.id.filterButton);
        cancel_btn = view.findViewById(R.id.btn_cancel);
        edt_search = view.findViewById(R.id.searchbar);


        View bottomSheet = view.findViewById(R.id.design_bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        gridView = view.findViewById(R.id.gridview);
        BranchAdapter adapter = new BranchAdapter(getActivity(), branches);
        gridView.setAdapter(adapter);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        edt_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    startActivity(new Intent(getActivity(), Results.class));
                    return true;
                }
                return false;
            }
        });

        return view;

    }

    private void performSearch() {
        edt_search.clearFocus();
        InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);

    }

    public class BranchAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;
        private Context context;
        private String[] names;

        public BranchAdapter(Context context, String[] names) {
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.context = context;
            this.names = names;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                view = layoutInflater.inflate(R.layout.product_grid_card, viewGroup, false);
            }

            TextView name = view.findViewById(R.id.grid_product_title);
            ImageView imageView = view.findViewById(R.id.grid_image);
            RelativeLayout layout = view.findViewById(R.id.grid_layout);

            name.setText(names[i]);
            imageView.setImageResource(images[i]);
            layout.setBackgroundResource(backgrounds[i]);
            return view;
        }
    }

}
