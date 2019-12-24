package com.example.musicfinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TagArtistAdapter extends RecyclerView.Adapter<TagArtistAdapter.ViewHolderArSe>{
    String mName[];
    CardView artistSearchCardView;
    String mRanks[];
    String mUrls[];
    String mGenre;

    public TagArtistAdapter(String[] mName, String[] mRanks, String[] mUrls, String mGenre) {
        this.mName = mName;
        this.mRanks = mRanks;
        this.mUrls = mUrls;
        this.mGenre = mGenre;
    }

    @NonNull
    @Override
    public TagArtistAdapter.ViewHolderArSe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tag_artist_item, parent, false);

        ViewHolderArSe vh = new ViewHolderArSe(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TagArtistAdapter.ViewHolderArSe holder, int position) {




        // glide.load(myImgUrl[position]).into(holder.imgAr);
        // glide.load(myImgUrl[position]).into(holder.imgAr);
        holder.artistName.setText(mName[position]);
        holder.artistGenre.setText("genre :" + mGenre);
        holder.artistRank.setText("rank : "+mRanks[position]);
        holder.artistUrl.setText(mUrls[position]);
    }

    @Override
    public int getItemCount() {
        if(mRanks!=null)
            return mRanks.length;
        else
            return 0;
    }

    public static class ViewHolderArSe extends RecyclerView.ViewHolder {
       public CardView tagArtistCard;
       public TextView artistName,artistUrl,artistRank,artistGenre;

        public ViewHolderArSe( View itemView) {

            super(itemView);
            tagArtistCard=itemView.findViewById(R.id.tagTopArtistSearchCardView);
            artistName=itemView.findViewById(R.id.ArtistName);
            artistUrl=itemView.findViewById(R.id.ArtUrl);
            artistRank=itemView.findViewById(R.id.ArtistRank);
            artistGenre=itemView.findViewById(R.id.ArtistGenre);
        }

    }
}
