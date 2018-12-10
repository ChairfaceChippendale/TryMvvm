package com.ujujzk.mobile.ui.projects

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ujujzk.domain.intractor.browse.AddProjectUseCase
import com.ujujzk.domain.intractor.browse.GetProjectsUseCase
import com.ujujzk.domain.model.Project
import com.ujujzk.mobile.model.ProjectView
import com.ujujzk.mobile.model.mapper.ProjectFromDomainToPresentMapper
import com.ujujzk.mobile.model.wrapper.DataWrapper
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseProjectsVM
@Inject
constructor(
        val getProjectsUc: GetProjectsUseCase,
        val addProjectUc: AddProjectUseCase,
        val mapper: ProjectFromDomainToPresentMapper)
    : ViewModel() {

    val liveData: MutableLiveData<DataWrapper<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getProjectsUc.dispose()
        super.onCleared()
    }


    fun getLifeData() = liveData


    fun fetchProjects() {
        liveData.postValue(DataWrapper.loading())
        getProjectsUc.execute(object : DisposableObserver<List<Project>>() {

            override fun onNext(data: List<Project>) = liveData.postValue(DataWrapper.success(data.map { mapper.mapToView(it) }))

            override fun onComplete() = Unit

            override fun onError(e: Throwable) = liveData.postValue(DataWrapper.error(e.localizedMessage))

        }, GetProjectsUseCase.Params.get())
    }

    fun addProject(name: String, imageUrl: String) {
        liveData.postValue(DataWrapper.loading())
        addProjectUc.execute(object : DisposableObserver<Project>(){

            override fun onNext(t: Project) {
                liveData.value?.data
            }
            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onError(e: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
}