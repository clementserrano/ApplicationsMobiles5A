package com.clementserrano.tp1.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.adapter.CommentAdapter;
import com.clementserrano.tp1.model.Comment;

public class MainActivity extends AppCompatActivity {

    private TextView movieTitle;
    private TextView movieOriginalTitle;
    private TextView movieDesc;
    private TextView movieKeywords;
    private ImageView movieImage;
    private Button likeButton;
    private Button commentButton;
    private ImageButton sendButton;
    private EditText commentEdit;
    private boolean toggleLike;
    private boolean toggleComment;
    private RecyclerView mRecyclerView;

    private Button backButton;
    private ImageButton crossButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView & Image
        this.movieTitle = findViewById(R.id.movieTitle);
        this.movieOriginalTitle = findViewById(R.id.movieOriginalTitle);
        this.movieDesc = findViewById(R.id.movieDesc);
        this.movieKeywords = findViewById(R.id.movieKeywords);
        this.movieImage = findViewById(R.id.movieImage);


        // Boutons

        this.backButton = findViewById(R.id.backTitle);
        this.crossButton = findViewById(R.id.cross);
        this.likeButton = findViewById(R.id.like);
        this.commentButton = findViewById(R.id.comment);
        this.commentEdit = findViewById(R.id.commentEdit);
        this.sendButton = findViewById(R.id.send);
        this.toggleLike = false;
        this.toggleComment = false;

        this.backButton.setOnClickListener(clickBack);
        this.crossButton.setOnClickListener(clickExit);
        this.likeButton.setOnClickListener(clickLike);
        this.commentButton.setOnClickListener(clickComment);
        this.sendButton.setOnClickListener(clickSend);

        // Commentaires

        this.mRecyclerView = findViewById(R.id.commentSection);

        CommentAdapter commentAdapter = new CommentAdapter();

        this.mRecyclerView.setAdapter(commentAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setNestedScrollingEnabled(false);
        this.mRecyclerView.getAdapter().notifyDataSetChanged();

        commentAdapter.addComment(new Comment("Jean-Michel", "Film interstellaire !", R.drawable.pig));
        commentAdapter.addComment(new Comment("Jean-Michel", "Solo meurt dans le 7.", R.drawable.pig));
        commentAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private View.OnClickListener clickBack = v -> {
        Intent intent = new Intent(MainActivity.this, MovieListActivity.class);
        startActivity(intent);
    };

    private View.OnClickListener clickExit = v -> {
        finish();
        System.exit(0);
    };

    private View.OnClickListener clickLike = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            if (toggleLike) {
                likeButton.setBackgroundResource(R.drawable.bg_button);
                likeButton.setTextColor(Color.WHITE);
                likeButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));
                toggleLike = false;
            } else {
                likeButton.setBackgroundResource(R.drawable.bg_button_selected);
                likeButton.setTextColor(Color.BLACK);
                likeButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.BLACK));
                toggleLike = true;
            }
        }
    };

    private View.OnClickListener clickComment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            commentEdit.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(commentEdit, InputMethodManager.SHOW_IMPLICIT);
        }
    };

    private View.OnClickListener clickSend = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(commentEdit.getText());
            AlertDialog dialog = builder.create();
            dialog.show();

            Comment comment = new Comment("Jean-Michel", commentEdit.getText().toString(), R.drawable.pig);

            CommentAdapter commentAdapter = ((CommentAdapter) mRecyclerView.getAdapter());

            commentAdapter.addComment(comment);
            commentAdapter.notifyDataSetChanged();

            commentEdit.setText("");
        }
    };
}
