package org.pursuit.retrofitreview.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.pursuit.retrofitreview.MainActivity;
import org.pursuit.retrofitreview.R;
import org.pursuit.retrofitreview.model.Cameras;
import org.pursuit.retrofitreview.model.Rovers;
import org.pursuit.retrofitreview.network.PhotoService;
import org.pursuit.retrofitreview.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PhotoViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "image_call";
    private static ImageView photoView;
    private static View itemView;
    private static Intent intent;

    public PhotoViewHolder(@NonNull final View itemView) {
        super(itemView);
        photoView = itemView.findViewById(R.id.photo_image_view);
    }

        public static void onBind(final Integer integer){
            photoView.setImageResource(integer);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(itemView.getContext(), MainActivity.class);
                    intent.putExtra("photo", integer);

                    Retrofit retrofit = RetrofitSingleton.getInstance();
                    PhotoService photoService = retrofit.create(PhotoService.class);
                    Call<Rovers> photo = photoService.getRovers();
                    photo.enqueue(new Callback<Rovers>() {


                        @Override
                        public void onResponse(Call<Rovers> call, Response<Rovers> response) {
                            Log.d(TAG, "onResponse: " + response.body().getPhotos());
                            intent.putExtra("name", response.body().getCamera());
                            itemView.getContext().startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Rovers> call, Throwable t) {
                            Log.d(TAG, "onResponse: " + t.toString());
                        }

                    });


                }
            });
        }
}
