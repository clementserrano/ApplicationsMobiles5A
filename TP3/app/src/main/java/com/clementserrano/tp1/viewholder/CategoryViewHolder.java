package com.clementserrano.tp1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Category;

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
