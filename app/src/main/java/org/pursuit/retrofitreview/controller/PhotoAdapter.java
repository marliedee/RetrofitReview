package org.pursuit.retrofitreview.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.retrofitreview.R;
import org.pursuit.retrofitreview.views.PhotoViewHolder;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    List<Integer> imageList;

    public PhotoAdapter(List <Integer> imageList) {
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_item_view, viewGroup, false);
        return new PhotoViewHolder(childView);    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int i) {
        PhotoViewHolder.onBind(imageList.get(i));

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
