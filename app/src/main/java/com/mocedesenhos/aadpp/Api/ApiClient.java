package com.mocedesenhos.aadpp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class ApiClient {


    private String BASE_URL="https://gadsapi.herokuapp.com/";


        public static  Api getAPi()
        {
            Api api=getRetrofit().create(Api.class);

            return api;

        }
    public static Retrofit getRetrofit() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        return retrofit;
    }



}
