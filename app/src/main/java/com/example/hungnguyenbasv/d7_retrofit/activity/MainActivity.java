package com.example.hungnguyenbasv.d7_retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.hungnguyenbasv.d7_retrofit.R;
import com.example.hungnguyenbasv.d7_retrofit.adapter.UserAdapter;
import com.example.hungnguyenbasv.d7_retrofit.model.User;
import com.example.hungnguyenbasv.d7_retrofit.remote.APIService;
import com.example.hungnguyenbasv.d7_retrofit.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private APIService mAPIService;
    private static final String TAG = "MainActivity TAG";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAPIService = RetrofitClient.getClient(APIService.BASE_URL).create(APIService.class);

        Call<List<User>> call = mAPIService.getAll();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> list = response.body();
                recyclerView.setAdapter(new UserAdapter(list, R.layout.row_item, MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }

        });
    }
}
