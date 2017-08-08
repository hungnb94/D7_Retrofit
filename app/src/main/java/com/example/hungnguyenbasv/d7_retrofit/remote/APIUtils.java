package com.example.hungnguyenbasv.d7_retrofit.remote;

/**
 * Created by hung.nguyenba.sv on 7/18/2017.
 */
public class APIUtils {

    public APIUtils() {
    }

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
