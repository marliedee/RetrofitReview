package org.pursuit.nasa_roverview.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.nasa_roverview.DisplayActivity;
import org.pursuit.nasa_roverview.R;
import org.pursuit.nasa_roverview.model.PhotoRovers;

public class NASAViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageViewRV;
    private TextView textViewRV;

    public NASAViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewRV = itemView.findViewById(R.id.imageview);
        textViewRV = itemView.findViewById(R.id.textview);
    }

    public void onBind(final PhotoRovers nasapojo) {

        textViewRV.setText(nasapojo.getEarth_date());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra("image",nasapojo.getImg_src());
                intent.putExtra("date", nasapojo.getEarth_date());
                itemView.getContext().startActivity(intent);

            }
        });
    }
}
