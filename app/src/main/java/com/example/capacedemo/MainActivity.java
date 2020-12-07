package com.example.capacedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<JSONResponse.Datum> mArrayList ;
    private List<JSONResponse.LocationData> locations_array;
    RecyclerView recycler_id;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        recycler_id = findViewById(R.id.recycler_id);
        recycler_id.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recycler_id.setLayoutManager(manager);
        getUrlData();

    }
    private void getUrlData() {
        RequestInterface restAPI = ApiClient.retrofit.create(RequestInterface.class);
        System.out.println("================+++============="+restAPI);
        retrofit2.Call<JSONResponse> call = restAPI.getEmployeData();
        System.out.println("================+++============="+call);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(retrofit2.Call<JSONResponse> call, Response<JSONResponse> response) {
                System.out.println("================+++============="+call+","+response);
                mArrayList = new ArrayList<>();
                mArrayList.clear();
                JSONResponse jsonResponse = response.body();

                if (response!=null) {
                    mArrayList = jsonResponse.getData();
                    locations_array = jsonResponse.getLocation_data();

                    for(int i=0; i<mArrayList.size();i++){
                        dataAdapter = new DataAdapter(getApplicationContext(),mArrayList);
                        recycler_id.setAdapter(dataAdapter);

                       // System.out.println("================+++============="+dataAdapter);
                    }

                    for (int j= 0; j<locations_array.size(); j++){
                        String lat = locations_array.get(j).getLat();
                        String longg = locations_array.get(j).getLongg();

                    }


                }else {
                    Toast.makeText(MainActivity.this, "Response Error", Toast.LENGTH_SHORT).show();

                    }
                }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server not Responding", Toast.LENGTH_SHORT).show();

            }

        });

    }
}