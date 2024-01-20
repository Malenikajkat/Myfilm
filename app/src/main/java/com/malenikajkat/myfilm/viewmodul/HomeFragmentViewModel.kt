package com.malenikajkat.myfilm.viewmodul

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malenikajkat.myfilm.App
import com.malenikajkat.myfilm.domain.Film
import com.malenikajkat.myfilm.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData:  MutableLiveData<List<Film>> = MutableLiveData()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess(films: List<Film>) {
                filmsListLiveData.postValue(films)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }
}