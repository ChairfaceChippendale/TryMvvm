package com.ujujzk.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ujujzk.domain.intractor.browse.GetBookmarkedProjectsUseCase
import com.ujujzk.domain.model.Project
import com.ujujzk.presentation.mapper.ProjectFromDomainToPresentMapper
import com.ujujzk.presentation.model.ProjectView
import com.ujujzk.presentation.state.Resource
import com.ujujzk.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseBookmarkedProjectsVM
@Inject constructor(
        val getBookmarkedProjectsUc: GetBookmarkedProjectsUseCase,
        val mapper: ProjectFromDomainToPresentMapper): ViewModel(){

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getBookmarkedProjectsUc.dispose()
        super.onCleared()
    }

    fun getProjects() = liveData

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getBookmarkedProjectsUc.execute(object : DisposableObserver<List<Project>>(){

            override fun onNext(t: List<Project>) = liveData.postValue(Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it) }, null))

            override fun onComplete() = Unit

            override fun onError(e: Throwable) = liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }, GetBookmarkedProjectsUseCase.Params.get())
    }
}