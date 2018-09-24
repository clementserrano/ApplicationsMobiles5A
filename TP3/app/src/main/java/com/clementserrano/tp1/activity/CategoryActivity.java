package com.clementserrano.tp1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.adapter.CategoryAdapter;
import com.clementserrano.tp1.manager.MovieManager;
import com.clementserrano.tp1.model.Category;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Category> mCategories;

    private Button backButton;
    private ImageButton crossButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        this.mRecyclerView = findViewById(R.id.listCategory);
        this.backButton = findViewById(R.id.backTitle);
        this.crossButton = findViewById(R.id.cross);

        this.backButton.setOnClickListener(clickBack);
        this.crossButton.setOnClickListener(clickExit);

        CategoryAdapter categoryAdapter = new CategoryAdapter();

        mCategories = MovieManager.getInstance().getCategories();

        categoryAdapter.setmCategories(mCategories);

        this.mRecyclerView.setAdapter(categoryAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private View.OnClickListener clickBack = v -> {
        finish();
    };

    private View.OnClickListener clickExit = v -> {
        finish();
        System.exit(0);
    };
}
