package kib.dev.kibnews.api

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import kib.dev.kibnews.BuildConfig
import kib.dev.kibnews.init.App
import kib.dev.kibnews.tools.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiBuilder {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header(NEWSAPI_HEADER_KEY_APIKEY, NEWSAPI_HEADER_VALUE_APIKEY)
                builder.header(NEWSAPI_HEADER_KEY_ACCEPT, NEWSAPI_HEADER_VALUE_APPLICATION_JSON)

                return@Interceptor chain.proceed(builder.build())
            }
        )
        addInterceptor(AppInterceptor(App.appContext()))
        addInterceptor(ChuckerInterceptor(App.appContext()))
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(NEWSAPI_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    private class AppInterceptor(val context: Context) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Application_Id", BuildConfig.APPLICATION_ID)
                .addHeader("Version_Name", BuildConfig.VERSION_NAME)
                .addHeader("Version_Code", BuildConfig.VERSION_CODE.toString())
                .build()
            return chain.proceed(request)
        }//: intercept
    }

}