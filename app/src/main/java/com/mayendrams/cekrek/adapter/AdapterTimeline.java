package com.mayendrams.cekrek.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mayendrams.cekrek.R;
import com.mayendrams.cekrek.model.ModelTimeline;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterTimeline extends RecyclerView.Adapter<AdapterTimeline.ViewHolder> {

    private List<ModelTimeline> films;
    private AdapterTimeline.OnCallbackListener listener;

    public AdapterTimeline(List<ModelTimeline> films) {
        this.films = films;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_timeline, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelTimeline film = films.get(position);
        holder.namatimeline.setText(film.getNamatimeline());
        Picasso.get().load(film.getFototimeline()).into(holder.fototimeline);


    }


    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setOnCallbackListener(AdapterTimeline.OnCallbackListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        CircleImageView profiletimeline;
        ImageView fototimeline;
        TextView namatimeline;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            profiletimeline = itemView.findViewById(R.id.containstoryprofileimg);
            fototimeline = itemView.findViewById(R.id.containtimelineimg);
            namatimeline = itemView.findViewById(R.id.containtimelinetxt);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(films.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(ModelTimeline user);
    }
}
