package com.ujujzk.domain.intractor.browse

import com.ujujzk.domain.executor.PostExecutionThread
import com.ujujzk.domain.gateway.ProjectGateway
import com.ujujzk.domain.intractor.ObservableUseCase
import com.ujujzk.domain.model.Project
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class GetProjectsUseCase
@Inject constructor(
        postExecutionThread: PostExecutionThread,
        disposables: CompositeDisposable,
        private val projectGateway: ProjectGateway)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread, disposables) {

    override fun build(params: Nothing): Observable<List<Project>> = projectGateway.getProjects()

}