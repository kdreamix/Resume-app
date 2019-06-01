package com.mak.demomvrx.models

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation

data class ProjectWithDetail (
    @Embedded
    val project: Project,

    @Relation(parentColumn = "id", entityColumn = "projectId", entity = ProjectDetail::class)
    val projectDetails:List<ProjectDetail>


){
    @Ignore constructor(project: Project) : this(project, emptyList())
}

fun List<ProjectWithDetail>.findProject(id: Int?) = firstOrNull{it.project.id == id}