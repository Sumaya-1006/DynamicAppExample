package com.example.dynamicappexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    Context context;
    List<Post> postsList;

    public PostAdapter(Context context, List<Post> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.userId.setText(String.valueOf(postsList.get(position).getUserId()));
        holder.txtId.setText(String.valueOf(postsList.get(position).getId()));
        holder.txtTitle.setText(String.valueOf(postsList.get(position).getTitle()));
       // holder.txtBody.setText(new StringBuilder(postsList.get(position).getBody().substring(0,20))
               // .append("...").toString());
        holder.txtBody.setText(String.valueOf(postsList.get(position).getBody()));

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
    class PostViewHolder extends RecyclerView.ViewHolder {
       TextView txtTitle,txtBody,txtId,userId;

       public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtBody = itemView.findViewById(R.id.txtBody);
        txtId = itemView.findViewById(R.id.txtId);
        userId = itemView.findViewById(R.id.userId);
    }
}



