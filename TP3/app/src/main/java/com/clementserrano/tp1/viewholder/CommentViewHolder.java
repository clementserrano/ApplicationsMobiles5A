package com.clementserrano.tp1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Comment;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private TextView mCommentUser;
    private TextView mCommentContent;
    private ImageView mCommentImg;

    public CommentViewHolder(View itemView) {
        super(itemView);
        this.mCommentUser = itemView.findViewById(R.id.commentUser);
        this.mCommentContent = itemView.findViewById(R.id.commentContent);
        this.mCommentImg = itemView.findViewById(R.id.commentImg);
    }

    public void layoutForComment(Comment comment) {
        if (comment != null) {
            if (mCommentUser != null) {
                mCommentUser.setText(comment.getUser());
            }
            if (mCommentContent != null) {
                mCommentContent.setText(comment.getContent());
            }
            if (mCommentImg != null) {
                // Set mCommentImg image
                mCommentImg.setImageResource(R.drawable.pig);
            }
        }
    }
}
