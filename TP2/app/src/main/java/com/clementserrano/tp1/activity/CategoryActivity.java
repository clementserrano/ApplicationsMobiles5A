package com.clementserrano.tp1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.clementserrano.tp1.adapter.CategoryAdapter;
import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Category> mCategories;

    private String[] arrayCategory = new String[]{"Humour", "Film d'horreur", "Comédie",
            "Action", "Aventure", "Humour", "Documentaire", "Policier", "Porno", "Drame", "Chiant",
            "Post-Apocalypse", "Science-Fiction", "Sport", "Super Héros"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        this.mRecyclerView = findViewById(R.id.listCategory);

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        List<String> listCategories = new ArrayList<>();
        listCategories.addAll(Arrays.asList(arrayCategory));
        mCategories = new ArrayList<>();
        for (String category : listCategories) {
            mCategories.add(new Category(category));
        }
        categoryAdapter.setmCategories(mCategories);

        this.mRecyclerView.setAdapter(categoryAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
