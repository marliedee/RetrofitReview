package org.pursuit.nasa_roverview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.nasa_roverview.controller.NASA_Adapter;
import org.pursuit.nasa_roverview.model.NASAPOJO;
import org.pursuit.nasa_roverview.model.PhotoRovers;
import org.pursuit.nasa_roverview.network.NASAService;
import org.pursuit.nasa_roverview.network.RetrofitNASASingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView textView;
    private ImageView imageView;
    private NASA_Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private Retrofit retro;
    private final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.NASAView);
        textView = findViewById(R.id.textview);
        imageView = findViewById(R.id.imageview);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        retro = RetrofitNASASingleton.getInstance();
        NASAService service = retro.create(NASAService.class);
        final Call<NASAPOJO> nasaPOJOCall = service.getDetails();
        nasaPOJOCall.enqueue(new Callback<NASAPOJO>() {
            @Override
            public void onResponse(Call<NASAPOJO> call, Response<NASAPOJO> response) {
                NASAPOJO nasapojos = response.body();
                List<PhotoRovers>nasapojoslist = nasapojos.getPhotos();
                adapter = new NASA_Adapter(nasapojoslist);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NASAPOJO> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());
            }
        });

    }
}
