package com.clementserrano.tp1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clementserrano.tp1.viewholder.CategoryViewHolder;
import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Category;

import java.util.List;

public class CategoryAdapter extends Adapter {

    private List<Category> mCategories;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        CategoryViewHolder vh = new CategoryViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Category currentCategory = mCategories.get(position);
        if(holder instanceof CategoryViewHolder && currentCategory != null){
            CategoryViewHolder viewHolder = (CategoryViewHolder) holder;
            viewHolder.layoutForCategory(currentCategory);
        }
    }

    @Override
    public int getItemCount() {
        if (mCategories != null) {
            return mCategories.size();
        }
        return 0;
    }

    public void setmCategories(List<Category> mCategories) {
        this.mCategories = mCategories;
    }
}
