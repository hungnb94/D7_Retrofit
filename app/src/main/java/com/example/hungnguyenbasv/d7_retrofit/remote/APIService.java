package com.example.hungnguyenbasv.d7_retrofit.remote;

import com.example.hungnguyenbasv.d7_retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hung.nguyenba.sv on 7/18/2017.
 */

public interface APIService {
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<User>> getAll();
}
