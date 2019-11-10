package com.example.newsanchor.services.api

import com.example.newsanchor.helpers.Const
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
object ServiceGenerator {
    fun <S> createService(serviceClass: Class<S>): S {

        val gson = GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .setPrettyPrinting()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(LogInspector.client())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(serviceClass)
    }
}