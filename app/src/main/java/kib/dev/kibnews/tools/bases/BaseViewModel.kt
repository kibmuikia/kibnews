package kib.dev.kibnews.tools.bases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    companion object {
        val logTag = BaseViewModel::class.java.simpleName
    }

    val loading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun setLoading(gotLoading: Boolean) {
        loading.postValue(gotLoading)
    }

    init {
        //.
    }

    override fun onCleared() {
        super.onCleared()
        //.
    }

}