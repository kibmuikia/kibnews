package kib.dev.kibnews.api

import kib.dev.kibnews.model.NewsApiResponse
import kib.dev.kibnews.tools.NEWSAPI_EP_TOPHEADLINES
import kib.dev.kibnews.tools.NEWSAPI_VERSION
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiEndPoints {

    @GET("${NEWSAPI_VERSION}${NEWSAPI_EP_TOPHEADLINES}")
    //fun getTopHeadlines(): Call<NewsApiResponse>
    fun getTopHeadlines(@Query("country") country: String): Call<NewsApiResponse>

}