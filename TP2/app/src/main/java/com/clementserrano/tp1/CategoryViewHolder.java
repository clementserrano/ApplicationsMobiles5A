package com.clementserrano.tp1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private Button mCategoryButton;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        this.mCategoryButton = itemView.findViewById(R.id.categoryButton);
    }

    public void layoutForCategory(Category category) {
        if (category != null) {
            if (mCategoryButton != null) {
                mCategoryButton.setText(category.getName());
            }
        }
    }
}
