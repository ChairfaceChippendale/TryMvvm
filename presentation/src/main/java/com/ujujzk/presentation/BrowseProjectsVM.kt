package com.ujujzk.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ujujzk.domain.intractor.bookmark.BookmarkProjectUseCase
import com.ujujzk.domain.intractor.bookmark.UnbookmarkProjectUseCase
import com.ujujzk.domain.intractor.browse.GetProjectsUseCase
import com.ujujzk.domain.model.Project
import com.ujujzk.presentation.mapper.ProjectFromDomainToPresentMapper
import com.ujujzk.presentation.model.ProjectView
import com.ujujzk.presentation.state.Resource
import com.ujujzk.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseProjectsVM
@Inject constructor(
        val getProjectsUs: GetProjectsUseCase,
        val bookmarkProjectUc: BookmarkProjectUseCase,
        val unbookmarkProjectUc: UnbookmarkProjectUseCase,
        val mapper: ProjectFromDomainToPresentMapper)
    : ViewModel() {

    val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    init {
        fetchProjects()
    }

    override fun onCleared() {
        getProjectsUs.dispose()
        super.onCleared()
    }


    fun getProjects() = liveData


    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getProjectsUs.execute(object : DisposableObserver<List<Project>>() {

            override fun onNext(data: List<Project>) = liveData.postValue(Resource(ResourceState.SUCCESS, data.map { mapper.mapToView(it) }, null))

            override fun onComplete() = Unit

            override fun onError(e: Throwable) = liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))

        }, GetProjectsUseCase.Params.get())
    }


    fun bookmarkProject(projectId: String) {
        bookmarkProjectUc.execute(object : DisposableCompletableObserver() {

            override fun onComplete() = liveData.postValue(Resource(ResourceState.SUCCESS, liveData.value?.data, null))

            override fun onError(e: Throwable) = liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))

        }, BookmarkProjectUseCase.Params.forProject(projectId))
    }


    fun unBookmarkProject(projectId: String) {
        unbookmarkProjectUc.execute(object : DisposableCompletableObserver() {

            override fun onComplete() = liveData.postValue(Resource(ResourceState.SUCCESS, liveData.value?.data, null))

            override fun onError(e: Throwable) = liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))

        }, UnbookmarkProjectUseCase.Params.forProject(projectId))
    }


}