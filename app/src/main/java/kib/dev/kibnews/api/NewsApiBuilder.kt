package kib.dev.kibnews.api

import kib.dev.kibnews.tools.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
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
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(NEWSAPI_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

}