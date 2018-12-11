package com.ujujzk.domain.intractor.browse

import com.ujujzk.domain.executor.PostExecutionThread
import com.ujujzk.domain.gateway.CatGateway
import com.ujujzk.domain.intractor.ObservableUseCase
import com.ujujzk.domain.intractor.SingleUseCase
import com.ujujzk.domain.model.Cat
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class GetCatsUseCase
@Inject constructor(
        postExecutionThread: PostExecutionThread,
        disposables: CompositeDisposable,
        private val catGateway: CatGateway)
    : SingleUseCase<List<Cat>, GetCatsUseCase.Params>(postExecutionThread, disposables) {

    override fun build(params: Params): Single<List<Cat>> = catGateway.getCats()

    class Params {
        companion object {
            fun get() = Params()
        }
    }
}