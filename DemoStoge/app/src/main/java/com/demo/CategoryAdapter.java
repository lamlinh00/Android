package com.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {


    ArrayList<Category> mListCategory;
    Context context;

////    IClickItemListener iClickItemListener;
//
//    public CategoryAdapter(ArrayList<Category> mListCategory, Context context, IClickItemListener iClickItemListener) {
//        this.mListCategory = mListCategory;
//        this.context = context;
//        this.iClickItemListener = iClickItemListener;
//    }
    public CategoryAdapter(ArrayList<Category> mListCategory, Context context) {
        this.mListCategory = mListCategory;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mListCategory.size();
    }

    @Override
    public Object getItem(int i) {
        return mListCategory.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category,viewGroup,false);

        Category category = mListCategory.get(i);
        ImageView imgIcon = view.findViewById(R.id.icon);
        TextView tvTitle = view.findViewById(R.id.title);
        TextView tvAuthor = view.findViewById(R.id.author);
        LinearLayout layout_item = view.findViewById(R.id.layout_item);

//        layout_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iClickItemListener.onClickItem(category);
//            }
//        });


        byte[] iconImage = category.getIcon();
        Bitmap bitmap= BitmapFactory.decodeByteArray(iconImage,0,iconImage.length);
        imgIcon.setImageBitmap(bitmap);//giai ma byte--> bitmap
        tvTitle.setText(category.getTitle());
        tvAuthor.setText(category.getAuthor());
        return view;
    }
}
