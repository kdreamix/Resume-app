package com.mak.demomvrx.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mak.demomvrx.models.Project
import com.mak.demomvrx.models.ProjectWithDetail
import io.reactivex.Flowable

@Dao
interface ProjectDao{
    @Query("SELECT * FROM Project")
    fun getAllProjects():Flowable<List<ProjectWithDetail>>

//    @Insert
//    fun insertAll(projectList: List<ProjectWithDetail>)
}