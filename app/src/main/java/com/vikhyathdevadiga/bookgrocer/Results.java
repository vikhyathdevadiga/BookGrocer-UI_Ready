package com.vikhyathdevadiga.bookgrocer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.vikhyathdevadiga.bookgrocer.Adapters.ProductListAdapter;

import java.util.ArrayList;

public class Results extends AppCompatActivity implements ProductListAdapter.OnSingleItemClicked{
    RecyclerView productList;
    ProductListAdapter adapter;
    private ArrayList<Product> contentList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        productList = findViewById(R.id.productListRecycler);

        productList.setHasFixedSize(true);
        productList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        contentList.add(new Product(R.drawable.product_1, 4, "The Heart of Hell", "Mitch Weiss", "The untold story of courage and sacrifice in the shadow of Iwo Jima."));
        contentList.add(new Product(R.drawable.purchased_1, 4, "Adrennes 1944", "Antony Beevor", "#1 international bestseller and award winning history book."));
        contentList.add(new Product(R.drawable.purchased_2, 3, "War on the Gothic Line", "Christian Jennings", "Through the eyes of thirteen men and women from seven different nations"));
        contentList.add(new Product(R.drawable.purchased_3, 3, "The Heart of Hell", "Mitch Weiss", "The untold story of courage and sacrifice in the shadow of Iwo Jima."));

        adapter = new ProductListAdapter(contentList, Results.this, getApplicationContext());
        productList.setAdapter(adapter);
    }

    @Override
    public void onSingleItemClick(int position, View view) {

    }
}