package kib.dev.kibnews.ui.activities.main_activity.fragments.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kib.dev.kibnews.api.NewsApiBuilder
import kib.dev.kibnews.api.NewsApiEndPoints
import kib.dev.kibnews.model.Article
import kib.dev.kibnews.model.NewsApiResponse
import kib.dev.kibnews.tools.bases.BaseViewModel
import retrofit2.Call
import retrofit2.Response

class HomeViewModel : BaseViewModel() {

    companion object {
        val logTag = HomeViewModel::class.java.simpleName
    }

    var number = 0

    val badgeCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val text: MutableLiveData<String> by lazy {
        MutableLiveData<String>("This is Home Fragment")
    }

    fun incrementBadgeCount() {
        badgeCount.postValue(++number)
    }

    fun getTopHeadlines() {

        val request = NewsApiBuilder.buildService(NewsApiEndPoints::class.java)
        val call = request.getTopHeadlines("us")
        setLoading(true)
        call.enqueue(object : retrofit2.Callback<NewsApiResponse> {
            override fun onResponse(
                call: Call<NewsApiResponse>,
                response: Response<NewsApiResponse>
            ) {
                setLoading(false)
                Log.e(logTag, ": getTopHeadlines: init: response: ${response.toString()}");
                if (response.isSuccessful) {
                    val body: NewsApiResponse? = response.body()
                    val status: String? = body?.status
                    val found: Int? = body?.totalResults
                    val articles: List<Article>? = body?.articles
                    Log.e(
                        logTag,
                        ": getTopHeadlines: status[ $status ], found[ $found ], articles[ size-${articles?.size} ]"
                    )
                } else {
                    Log.e(logTag, ": getTopHeadlines: response Unsuccessful");
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                setLoading(false)
                Log.e(logTag, ": getTopHeadlines-onFailure: message[ ${t.message} ]")
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
    }
}