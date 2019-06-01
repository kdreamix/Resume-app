package com.mak.demomvrx.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Project(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @DrawableRes val thumbnailRes: Int,
    val name: String,
    val time: String,
    val language: String,
    val introduction: String
)