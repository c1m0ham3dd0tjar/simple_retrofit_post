package com.retrofit_post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PostRequestAPI {

    @POST("post")
    Call<PostModel> PostDataIntoServer(@Body PostModel postModel);


    @PUT("put")
    Call<PostModel> UdpateData(@Body PostModel postModel);

    @PATCH("patch")
    Call<PostModel> PatchData(@Body PostModel postModel);


}
