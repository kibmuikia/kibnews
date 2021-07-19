package kib.dev.kibnews.ui.activities.main_activity.fragments.search

import androidx.lifecycle.MutableLiveData
import kib.dev.kibnews.tools.bases.BaseViewModel

class SearchViewModel : BaseViewModel() {

    companion object {
        val logTag: String = SearchViewModel::class.java.simpleName
    }

    val text: MutableLiveData<String> by lazy {
        MutableLiveData<String>("This is Search Fragment")
    }

    init {
        //.
    }

    override fun onCleared() {
        super.onCleared()
        //.
    }
}