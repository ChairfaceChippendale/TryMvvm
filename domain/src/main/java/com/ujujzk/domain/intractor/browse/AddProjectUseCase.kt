package com.ujujzk.domain.intractor.browse

import com.ujujzk.domain.executor.PostExecutionThread
import com.ujujzk.domain.gateway.ProjectGateway
import com.ujujzk.domain.intractor.ObservableUseCase
import com.ujujzk.domain.model.Project
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AddProjectUseCase
@Inject constructor(
        postExecutionThread: PostExecutionThread,
        disposables: CompositeDisposable,
        private val projectGateway: ProjectGateway)
    : ObservableUseCase<Project, AddProjectUseCase.Params>(postExecutionThread, disposables) {

    override fun build(params: Params): Observable<Project> = projectGateway.addProject(params.name, params.imageUrl)

    class Params (val name: String, val imageUrl: String){
        companion object {
            fun add(name: String, imageUrl: String) = Params(name, imageUrl)
        }
    }
}