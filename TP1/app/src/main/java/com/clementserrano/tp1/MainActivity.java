package com.clementserrano.tp1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button backButton;
    ImageButton crossButton;
    Button likeButton;
    Button commentButton;
    EditText commentEdit;
    ImageButton sendButton;
    TextView commentList;
    boolean toggleLike;
    boolean toggleComment;

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
        this.commentList = findViewById(R.id.commentList);
        this.toggleLike = false;
        this.toggleComment = false;

        this.backButton.setOnClickListener(clickExit);
        this.crossButton.setOnClickListener(clickExit);
        this.likeButton.setOnClickListener(clickLike);
        this.commentButton.setOnClickListener(clickComment);
        this.sendButton.setOnClickListener(clickSend);
    }

    private View.OnClickListener clickExit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            System.exit(0);
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
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(commentEdit.getText());
            AlertDialog dialog = builder.create();
            dialog.show();

            if (toggleComment) {
                commentList.setText(commentList.getText() + "\n" + commentEdit.getText());
                commentEdit.setText("");
            } else {
                commentList.setText(commentEdit.getText());
                commentEdit.setText("");
                commentList.setGravity(Gravity.NO_GRAVITY);
                commentList.setBackgroundResource(R.color.darkblue);
                toggleComment = true;
            }
        }
    };
}
