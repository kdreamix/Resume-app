package com.mak.demomvrx.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mak.demomvrx.models.Project
import com.mak.demomvrx.models.ProjectDetail
import com.mak.demomvrx.models.populate

@Database(entities = arrayOf(Project::class, ProjectDetail::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}