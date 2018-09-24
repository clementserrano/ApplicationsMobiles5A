package com.clementserrano.tp1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clementserrano.tp1.viewholder.CommentViewHolder;
import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter {

    private List<Comment> mComments = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment, parent, false);
        CommentViewHolder vh = new CommentViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comment currentComment = mComments.get(position);
        if (holder instanceof CommentViewHolder && currentComment != null) {
            CommentViewHolder viewHolder = (CommentViewHolder) holder;
            viewHolder.layoutForComment(currentComment);
        }
    }

    @Override
    public int getItemCount() {
        if (mComments != null) {
            return mComments.size();
        }
        return 0;
    }

    public void addComment(Comment comment) {
        mComments.add(comment);
    }

    public List<Comment> getmComments() {
        return mComments;
    }

    public void setmComments(List<Comment> mComments) {
        this.mComments = mComments;
    }
}
