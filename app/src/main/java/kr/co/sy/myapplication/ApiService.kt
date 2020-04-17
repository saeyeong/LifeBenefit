package kr.co.sy.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("/v1/auth/login")
    @FormUrlEncoded
    fun loginAccount(
        @Field("nickname") nickname : String,
        @Field("password") password : String
    ): Call<Auth>

}