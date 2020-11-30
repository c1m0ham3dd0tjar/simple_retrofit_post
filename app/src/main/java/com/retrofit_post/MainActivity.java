package com.retrofit_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText edtxt;
    Button btn;
    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtv=findViewById(R.id.txt);
        edtxt=findViewById(R.id.edtxt);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patchRetrofiData();
//                updateretrofiData();
//                callRetrofit();
            }
        });
    }
    private void updateretrofiData(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostRequestAPI postRequestAPI=retrofit.create(PostRequestAPI.class);
        PostModel postModel=new PostModel("post 55","post Changed Successfully");

        Call<PostModel> callupdate=postRequestAPI.UdpateData(postModel);

        callupdate.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                txtv.setText(response.body().getJson().getData());
                Toast.makeText(MainActivity.this,"Success "+response.code(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });

    }
    private void patchRetrofiData(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostRequestAPI postRequestAPI=retrofit.create(PostRequestAPI.class);
        PostModel postModel=new PostModel("patch title","patched");

        Call<PostModel> callupdate=postRequestAPI.PatchData(postModel);

        callupdate.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                txtv.setText(response.body().getJson().getData());
                Toast.makeText(MainActivity.this,"Success "+response.code(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });

    }
    private void callRetrofit() {
            String txt=edtxt.getText().toString();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        PostRequestAPI postRequestAPI=retrofit.create(PostRequestAPI.class);
        PostModel postModel=new PostModel("post 1",txt);

        Call<PostModel> call=postRequestAPI.PostDataIntoServer(postModel);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                txtv.setText(response.body().getJson().getData());
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });
    }
}