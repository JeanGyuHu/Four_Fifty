package com.example.gjwls.swhackui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] list_image = {
            R.drawable.egy,
            R.drawable.kor,
            R.drawable.usa
    };

    public String[] list_title = {
            "Egypt",
            "USA",
            "Korea"
    };

    public String[] list_description = {
            "Description 1",
            "Description 2",
            "Description 3",

    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_title.length;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slide,container, false);
        LinearLayout layoutslide = view.findViewById(R.id.slideLinearLayout);

        ImageView imageslide = (ImageView) view.findViewById(R.id.sliding);
        TextView txttitle = view.findViewById(R.id.txtTitle);
        TextView description = view.findViewById(R.id.txtDescription);
        imageslide.setImageResource(list_image[position]);
        txttitle.setText(list_title[position]);
        description.setText(list_description[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
