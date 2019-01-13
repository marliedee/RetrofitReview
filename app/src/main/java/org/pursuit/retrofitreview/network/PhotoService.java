package org.pursuit.retrofitreview.network;

import org.pursuit.retrofitreview.model.Rovers;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1&api_key=DEMO_KEY")
    Call<Rovers> getRovers();
}
