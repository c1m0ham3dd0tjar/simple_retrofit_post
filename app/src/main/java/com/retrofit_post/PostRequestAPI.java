package com.retrofit_post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostRequestAPI {

    @POST("post")
    Call<PostModel> PostDataIntoServer(@Body PostModel postModel);
}
