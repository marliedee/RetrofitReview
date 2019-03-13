package org.pursuit.nasa_roverview.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.nasa_roverview.R;
import org.pursuit.nasa_roverview.model.PhotoRovers;
import org.pursuit.nasa_roverview.view.NASAViewHolder;

import java.util.List;


public class NASA_Adapter extends RecyclerView.Adapter<NASAViewHolder> {

    public NASA_Adapter(List<PhotoRovers> NASAPOJOList) {
        this.NASAPOJOList = NASAPOJOList;
    }

    private List<PhotoRovers> NASAPOJOList;

    @NonNull
    @Override
    public NASAViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nasa_list_view, viewGroup, false);
        return new NASAViewHolder(childView);     }

    @Override
    public void onBindViewHolder(@NonNull NASAViewHolder nasaViewHolder, int i) {
        nasaViewHolder.onBind(NASAPOJOList.get(i));

    }

    @Override
    public int getItemCount() {
        return NASAPOJOList.size();
    }
}
