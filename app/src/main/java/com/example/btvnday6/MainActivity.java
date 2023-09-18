package com.example.btvnday6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rcvNewFeed;
    private ArrayList<Poster> mListPoster;
    private PosterAdapter mPosterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initData();
        initView();
    }

    private void initView() {
        rcvNewFeed = findViewById(R.id.rcvNewFeed);
        mPosterAdapter = new PosterAdapter(mListPoster);
        mPosterAdapter.setmCallback(clickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvNewFeed.setLayoutManager(linearLayoutManager);
        rcvNewFeed.setHasFixedSize(true);
        rcvNewFeed.setAdapter(mPosterAdapter);
    }

    private IUpdateAdapterListener clickListener = new IUpdateAdapterListener() {
        @Override
        public void onItemClick(int pos) {

        }

        @Override
        public void onChangeLike(int position) {
            Poster poster = mListPoster.get(position);
            poster.setLike(!poster.isLike());
            mListPoster.set(position, poster);
            mPosterAdapter.notifyItemChanged(position);


        }

        @Override
        public void onDelete(int position) {
            mListPoster.remove(position);

            mPosterAdapter.notifyItemRemoved(position);

        }
    };


        private void initData() {
        mListPoster = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Poster poster  = new Poster();
            poster.setUserName("Poster" + i);
            poster.setTitle("Caption Something..." + i);
            poster.setUserAvatar("https://s.hs-data.com/bilder/spieler/gross/142263.jpg");
            poster.setPostImage("https://s.hs-data.com/bilder/spieler/gross/142263.jpg");
            poster.setLike(false);
            mListPoster.add(poster);
        }
    }
}