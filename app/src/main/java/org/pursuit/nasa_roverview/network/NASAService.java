package org.pursuit.nasa_roverview.network;

import org.pursuit.nasa_roverview.model.NASAPOJO;
import org.pursuit.nasa_roverview.model.PhotoRovers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NASAService {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1&api_key=DEMO_KEY")
    Call<NASAPOJO> getDetails();
}
