package com.ujujzk.domain.intractor.bookmark

import com.ujujzk.domain.executor.PostExecutionThread
import com.ujujzk.domain.gateway.ProjectGateway
import com.ujujzk.domain.intractor.CompletableUseCase
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UnbookmarkProjectUseCase
@Inject constructor(
        postExecutionThread: PostExecutionThread,
        disposables: CompositeDisposable,
        private val projectGateway: ProjectGateway)
    : CompletableUseCase<UnbookmarkProjectUseCase.Params>(postExecutionThread, disposables){

    override fun build(params: Params): Completable = projectGateway.unbookmarkProject(params.projectId)


    data class Params (val projectId: String){
        companion object {
            fun forProject(projectId: String) = Params(projectId)
        }
    }
}