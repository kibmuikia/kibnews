package kib.dev.kibnews.ui.activities.main_activity.fragments.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kib.dev.kibnews.api.NewsApiBuilder
import kib.dev.kibnews.api.NewsApiEndPoints
import kib.dev.kibnews.model.Article
import kib.dev.kibnews.model.NewsApiResponse
import retrofit2.Call
import retrofit2.Response

class HomeViewModel : ViewModel() {

    // **
    val logTag = HomeViewModel::class.java.simpleName

    private val _badgeCount = MutableLiveData<Int>()
    var number = 0

    val badgeCount: LiveData<Int>
        get() = _badgeCount

    fun incrementBadgeCount() {
        _badgeCount.postValue(++number)
    }

    fun getTopHeadlines() {

        val request = NewsApiBuilder.buildService(NewsApiEndPoints::class.java)
        val call = request.getTopHeadlines()

        call.enqueue(object : retrofit2.Callback<NewsApiResponse> {
            override fun onResponse(
                call: Call<NewsApiResponse>,
                response: Response<NewsApiResponse>
            ) {
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
                Log.e(logTag, ": getTopHeadlines-onFailure: message[ ${t.message} ]")
            }

        })

    }

    override fun onCleared() {
        super.onCleared()
        Log.e(logTag, ": onCleared: init")
        //number = 0
    }
    // **

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}