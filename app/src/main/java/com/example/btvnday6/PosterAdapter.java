package com.example.btvnday6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder> {

    private ArrayList<Poster> mListData;
    private Context mContext;

    private IUpdateAdapterListener mCallback;


    public void setmCallback(IUpdateAdapterListener mCallback) {
        this.mCallback = mCallback;
    }

    public PosterAdapter(ArrayList<Poster> mListData) {
        this.mListData = mListData;
    }

    @NonNull
    @Override
    public PosterAdapter.PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_newfeed,parent,false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterAdapter.PosterViewHolder holder, int position) {

        Poster poster = mListData.get(position);
        holder.userName.setText(poster.getUserName());
        holder.title.setText(poster.getTitle());

        Glide.with(mContext).load(poster.getUserAvatar()).into(holder.imgAvatar);
        Glide.with(mContext).load(poster.getPostImage()).into(holder.imgPost);
        if (poster.isLike()){
            Glide.with(mContext).load(R.drawable.icon_like_2).into(holder.imgLike);
        }else {
            Glide.with(mContext).load(R.drawable.icon_like).into(holder.imgLike);
        }

    }

    @Override
    public int getItemCount() {
        return mListData != null ?  mListData.size() : 0;
    }

    public class PosterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView userName, title;
        ImageView imgAvatar, imgPost,imgLike,imgRemove;

        CardView llProductItemMain;
        public PosterViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userNamme);
            title = itemView.findViewById(R.id.title);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            imgPost = itemView.findViewById(R.id.imgPost);
            imgLike = itemView.findViewById(R.id.imgLike);
            imgRemove = itemView.findViewById(R.id.imgRemove);
            llProductItemMain = itemView.findViewById(R.id.llProductItemMain);

            llProductItemMain.setOnClickListener(this);
            imgRemove.setOnClickListener(this);
            imgLike.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.llProductItemMain:
                    int position = getAdapterPosition();
                    if (mCallback != null) {
                       mCallback.onItemClick(position);
                    }
                   break;

                case R.id.imgRemove:
                    mCallback.onDelete(getAdapterPosition());
                    break;
                case R.id.imgLike:
                    mCallback.onChangeLike(getAdapterPosition());
                    break;

            }
        }
    }
}
