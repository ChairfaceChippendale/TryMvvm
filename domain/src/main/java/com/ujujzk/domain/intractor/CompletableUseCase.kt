package com.ujujzk.domain.intractor

import com.ujujzk.domain.executor.PostExecutionThread
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class CompletableUseCase<in Params>
constructor(
        private val postExecutionThread: PostExecutionThread,
        private val compositeDisposable: CompositeDisposable
) {

    protected abstract fun build(params: Params): Completable

    open fun execute(observer: DisposableCompletableObserver, params: Params){
        val completable = this.build(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
        addDisposable(completable.subscribeWith(observer))
    }

    fun dispose() = compositeDisposable.dispose()

    private fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

}