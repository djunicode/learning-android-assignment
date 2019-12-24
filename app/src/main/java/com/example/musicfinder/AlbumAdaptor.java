package com.example.musicfinder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
//import com.squareup.picasso.Picasso;
import java.util.List;
public class AlbumAdaptor extends RecyclerView.Adapter<AlbumAdaptor.ViewHolder> {
 List<AlbumResponseModel> list;
 Context context;

    public AlbumAdaptor(List<AlbumResponseModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        CardView cv=v.findViewById(R.id.cardview);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView url=v.findViewById(R.id.urldisplay);
                Intent redirectURL=new Intent("android.intent.action.VIEW",
                        Uri.parse(url.getText().toString()));

                context.startActivity(redirectURL);
            }
        });
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    AlbumResponseModel obj=list.get(position);
    holder.Artist.setText(obj.getArtist());
    holder.Url.setText(obj.getUrl());
    holder.name.setText(obj.getName());
        //if(obj.getImage().get(2).getSize()=="medium")
        //Picasso.with(context).load(obj.getImage().get(2).getUrl()).into(holder.imageview);
        //else
        //   holder.imageview.setImageResource(R.drawable.ic_play);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Artist,Url,name;
        ImageView imageview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Artist=itemView.findViewById(R.id.artistdisplay);
            Url=itemView.findViewById(R.id.urldisplay);
            name=itemView.findViewById(R.id.namedisplay);
           // imageview=itemView.findViewById(R.id.imageView);
        }
    }
}
