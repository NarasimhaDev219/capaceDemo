package com.example.capacedemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface RequestInterface {

    @GET("viewreport.php")
    @Streaming
    Call<JSONResponse> getEmployeData();
}
