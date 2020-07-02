package com.vikhyathdevadiga.bookgrocer.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.vikhyathdevadiga.bookgrocer.R;
import com.vikhyathdevadiga.bookgrocer.SignIn;
import com.vikhyathdevadiga.bookgrocer.SignUp;

import static androidx.core.content.ContextCompat.startActivity;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    int[] headings = {R.string.first_slide_title, R.string.second_slide_title, R.string.third_slide_title};
    int[] subheadings = {R.string.first_slide_sub_title, R.string.second_slide_sub_title, R.string.third_slide_sub_title};

    int[] images = {R.drawable.illustration1, R.drawable.illustration2, R.drawable.illustration3};

    @Override
    public int getCount() {
        return headings.length + 1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container, false);

        TextView heading = view.findViewById(R.id.heading);
        TextView subheading = view.findViewById(R.id.subheading);
        ImageView imageView = view.findViewById(R.id.image);
        LinearLayout main = view.findViewById(R.id.main_layout);
        LinearLayout btnl = view.findViewById(R.id.button_layout);

        if (position ==3){
            view = layoutInflater.inflate(R.layout.signin_or_signup, container, false);
            view.findViewById(R.id.signup_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent signup = new Intent(context, SignUp.class);
                    context.startActivity(signup);
                }
            });

            view.findViewById(R.id.signin_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent signup = new Intent(context, SignIn.class);
                    context.startActivity(signup);
                }
            });

            container.addView(view);


//            main.setVisibility(View.GONE);
//            btnl.setVisibility(View.VISIBLE);
        }
        else {

            heading.setText(headings[position]);
            subheading.setText(subheadings[position]);
            imageView.setImageResource(images[position]);
            container.addView(view);
        }
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
