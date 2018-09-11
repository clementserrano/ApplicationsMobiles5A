package com.clementserrano.tp1;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeaderView extends LinearLayout {

    private TextView movieTitle;

    public HeaderView(Context context) {
        super(context);
        this.initialize(context, null);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initialize(context, attrs);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initialize(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        inflate(context, R.layout.header, this);
        this.movieTitle = findViewById(R.id.movieTitle);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0);

            String movieTitle = array.getString(R.styleable.HeaderView_movieTitle);
            if (this.movieTitle != null) {
                this.movieTitle.setText(movieTitle);
            }

            array.recycle();
        }
    }
}