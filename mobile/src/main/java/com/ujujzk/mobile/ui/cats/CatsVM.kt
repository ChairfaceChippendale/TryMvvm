package com.ujujzk.mobile.ui.cats

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import com.ujujzk.domain.intractor.browse.GetCatsUseCase
import com.ujujzk.domain.model.Cat
import com.ujujzk.mobile.model.CatView
import com.ujujzk.mobile.model.mapper.CatFromDomainToPresentMapper
import com.ujujzk.mobile.model.wrapper.DataWrapper
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class CatsVM
@Inject constructor(
        private val getCatsUc: GetCatsUseCase,
        private val catMapper: CatFromDomainToPresentMapper)
    : ViewModel() {

    val cats = MutableLiveData<List<CatView>>()


    val isLoading = ObservableBoolean()


    fun getCats() {
        Log.w("TAG", "get")
        if (cats.value == null && !isLoading.get()) {
            isLoading.set(true)
            Log.w("TAG", "load")
            getCatsUc.execute(
                    object : DisposableSingleObserver<List<Cat>>() {

                        override fun onSuccess(data: List<Cat>) {
                            isLoading.set(false)
                            cats.value = data.map { catMapper.mapToView(it) }
                            Log.w("TAG", "loaded")
                        }

                        override fun onError(e: Throwable) {
                            isLoading.set(false)
                        }

                    }, GetCatsUseCase.Params.get())
        } else {
            cats.postValue(cats.value)
        }

    }


}