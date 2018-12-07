package com.ujujzk.domain.intractor.browse

import com.ujujzk.domain.executor.PostExecutionThread
import com.ujujzk.domain.gateway.ProjectGateway
import com.ujujzk.domain.intractor.ObservableUseCase
import com.ujujzk.domain.model.Project
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class GetBookmarkedProjectsUseCase
@Inject constructor(
        postExecutionThread: PostExecutionThread,
        disposables: CompositeDisposable,
        private val projectGateway: ProjectGateway)
    : ObservableUseCase<List<Project>, GetBookmarkedProjectsUseCase.Params>(postExecutionThread, disposables) {

    override fun build(params: Params): Observable<List<Project>> = projectGateway.getBookmarkedProjects()

    class Params {
        companion object {
            fun get() = Params()
        }
    }
}