package com.mak.demomvrx.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProjectDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val projectId: Int,
    val title: String,
    val description: String,
    val screenShotRes: Int
)