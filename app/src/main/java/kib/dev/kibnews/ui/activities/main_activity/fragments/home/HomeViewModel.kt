package kib.dev.kibnews.ui.activities.main_activity.fragments.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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