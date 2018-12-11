package com.ujujzk.mobile.ui.cats

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ujujzk.data.cats.CatsGatewayImpl
import com.ujujzk.domain.intractor.browse.GetCatsUseCase
import com.ujujzk.domain.model.Cat
import com.ujujzk.mobile.UiThread
import com.ujujzk.mobile.model.CatView
import com.ujujzk.mobile.model.mapper.CatFromDomainToPresentMapper
import com.ujujzk.mobile.model.wrapper.DataWrapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class CatsVM : ViewModel() {

    private val catMapper: CatFromDomainToPresentMapper = CatFromDomainToPresentMapper()
    private val getCatsUc: GetCatsUseCase = GetCatsUseCase(UiThread(), CompositeDisposable(), CatsGatewayImpl())

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