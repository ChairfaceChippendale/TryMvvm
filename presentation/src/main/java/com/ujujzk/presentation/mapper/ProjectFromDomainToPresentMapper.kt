package com.ujujzk.presentation.mapper

import com.ujujzk.domain.model.Project
import com.ujujzk.presentation.model.ProjectView

class ProjectFromDomainToPresentMapper : Mapper<ProjectView, Project>{

    override fun mapToView(type: Project): ProjectView =
            ProjectView(type.id, type.name, type.fullName,
                    type.starCount, type.dateCreated, type.ownerName,
                    type.ownerAvatar, type.isBookmarked)
}