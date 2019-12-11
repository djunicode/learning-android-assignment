package com.example.musicfinder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterArtistSearch extends RecyclerView.Adapter<AdapterArtistSearch.ViewHolderArSe> {
    String myName[];
    CardView artistSearchCardView;
    String myListeners[];
    String myUrl[];



    public AdapterArtistSearch(String myName[], String myListeners[], String myUrl[])
    {
        this.myName=myName;
        this.myListeners=myListeners;
        this.myUrl=myUrl;
    }
    @NonNull
    @Override
    public ViewHolderArSe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.artist_search_item, parent, false);

        ViewHolderArSe vh = new ViewHolderArSe(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderArSe holder, int position) {

        //artistSearchCardView.setAlpha(0);
        //artistSearchCardView.animate().alpha(1).setDuration(1000);
        String string=position+1+". "+myName[position];
        holder.SingerName.setText(string);
        holder.SinUrl.setText(myUrl[position]);
        string="With "+myListeners[position]+" Listeners";
        holder.SinListeners.setText(string);
       // glide.load(myImgUrl[position]).into(holder.imgAr);
    }
    @Override
    public int getItemCount() {
        return myName.length;
    }

    public static class ViewHolderArSe  extends RecyclerView.ViewHolder
    {
        public CardView artistSearchCardView ;
        public TextView SingerName,SinListeners,SinUrl;
        //public ImageView imgAr;

        public ViewHolderArSe(View v)
        {
            super(v);
            SingerName=v.findViewById(R.id.SingerName);
            SinListeners=v.findViewById(R.id.SinListeners);
            SinUrl=v.findViewById(R.id.SinUrl);
            artistSearchCardView=v.findViewById(R.id.artistSearchCardView);
           // imgAr=v.findViewById(R.id.imgAr);
        }
    }
}
