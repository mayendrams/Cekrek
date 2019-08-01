package com.mayendrams.cekrek.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mayendrams.cekrek.R;
import com.mayendrams.cekrek.model.ModelStory;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.ViewHolder> {
    private List<ModelStory> films;
    private OnCallbackListener listener;

    public AdapterStory(List<ModelStory> films) {
        this.films = films;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.story_round, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelStory film = films.get(position);
//        holder.fotoStory.get(film.getFotostory());
        holder.namaStory.setText(film.getNamastory());
        Picasso.get().load(film.getFotostory()).into(holder.profilestory);


    }


    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        CircleImageView profilestory;
        TextView namaStory;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            profilestory = itemView.findViewById(R.id.containstoryprofileimg);
            namaStory = itemView.findViewById(R.id.containstorytxt);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(films.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(ModelStory user);
    }
}
