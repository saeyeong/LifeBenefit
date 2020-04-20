package kr.co.sy.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkHelper {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://question.api-namu.kro.kr:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var server: ApiService = retrofit.create(ApiService::class.java)

}