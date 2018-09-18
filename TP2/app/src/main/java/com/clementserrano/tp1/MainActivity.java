package com.clementserrano.tp1;

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

public class MainActivity extends AppCompatActivity {

    Button backButton;
    ImageButton crossButton;
    Button likeButton;
    Button commentButton;
    EditText commentEdit;
    ImageButton sendButton;
    boolean toggleLike;
    boolean toggleComment;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.backButton = findViewById(R.id.backTitle);
        this.crossButton = findViewById(R.id.cross);
        this.likeButton = findViewById(R.id.like);
        this.commentButton = findViewById(R.id.comment);
        this.commentEdit = findViewById(R.id.commentEdit);
        this.sendButton = findViewById(R.id.send);
        this.toggleLike = false;
        this.toggleComment = false;

        this.backButton.setOnClickListener(clickExit);
        this.crossButton.setOnClickListener(clickExit);
        this.likeButton.setOnClickListener(clickLike);
        this.commentButton.setOnClickListener(clickComment);
        this.sendButton.setOnClickListener(clickSend);

        this.mRecyclerView = findViewById(R.id.commentSection);

        CommentAdapter commentAdapter = new CommentAdapter();

        this.mRecyclerView.setAdapter(commentAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setNestedScrollingEnabled(false);
        this.mRecyclerView.getAdapter().notifyDataSetChanged();

        Comment comment = new Comment("Jean-Michel", "Film interstellaire !", "pig");
        Comment comment2 = new Comment("Jean-Michel", "Solo meurt dans le 7.", "pig");

        commentAdapter.addComment(comment);
        commentAdapter.addComment(comment2);
        commentAdapter.notifyDataSetChanged();
    }

    private View.OnClickListener clickExit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        }
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

            Comment comment = new Comment("Jean-Michel", commentEdit.getText().toString(), "pig");

            CommentAdapter commentAdapter = ((CommentAdapter) mRecyclerView.getAdapter());

            commentAdapter.addComment(comment);
            commentAdapter.notifyDataSetChanged();

            commentEdit.setText("");
        }
    };
}
