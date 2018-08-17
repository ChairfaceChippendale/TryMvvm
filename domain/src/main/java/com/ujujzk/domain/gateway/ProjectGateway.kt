package com.ujujzk.domain.gateway

import com.ujujzk.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable


interface ProjectGateway {

    fun getProjects(): Observable<List<Project>>

    fun bookmarkProject(projectId: String): Completable

    fun unbookmarkProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>
}