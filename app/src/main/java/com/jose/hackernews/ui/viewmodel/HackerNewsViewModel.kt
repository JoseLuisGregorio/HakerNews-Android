package com.jose.hackernews.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jose.hackernews.data.model.HackerNewProvider
import com.jose.hackernews.data.model.Hits
import com.jose.hackernews.domain.GetHackerNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HackerNewViewModel @Inject constructor(
    private val getHackerNewsUseCase: GetHackerNewsUseCase,
    private val hackerNewProvider: HackerNewProvider,
) : ViewModel() {

    val hackerNewsModel = MutableLiveData<ArrayList<Hits>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getHackerNewsUseCase()
            if (!result.isNullOrEmpty()) {
                hackerNewsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getArrayHackerNews() {
        val hackerNews = hackerNewProvider.hackerNews
        hackerNewsModel.postValue(ArrayList(hackerNews))
    }
}