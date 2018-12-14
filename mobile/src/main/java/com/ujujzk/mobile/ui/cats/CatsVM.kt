package com.ujujzk.mobile.ui.cats

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
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

    var cats: MutableLiveData<DataWrapper<List<CatView>>> = MutableLiveData()


    fun getCats() {
        cats.postValue(DataWrapper.loading())
        getCatsUc.execute(
                object : DisposableSingleObserver<List<Cat>>() {
                    override fun onSuccess(data: List<Cat>) =
                            cats.postValue(DataWrapper.success(data.map { catMapper.mapToView(it) }))

                    override fun onError(e: Throwable) =
                            cats.postValue(DataWrapper.error(e.localizedMessage))

                }, GetCatsUseCase.Params.get())
    }


}