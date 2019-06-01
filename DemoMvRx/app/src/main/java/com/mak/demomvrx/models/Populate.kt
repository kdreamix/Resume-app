package com.mak.demomvrx.models

import com.mak.demomvrx.R

fun populate() = listOf(
    ProjectWithDetail(
        project = Project(
            id = 1,
            thumbnailRes = 0,
            name = "Outback",
            time = "2017-2018",
            language = "Java",
            introduction = ""
        ), projectDetails = listOf()
    ),
    ProjectWithDetail(
        project = Project(
            id = 2,
            thumbnailRes = 0,
            name = "IDefect",
            time = "2017-2018",
            language = "Kotlin",
                    introduction = ""
        ), projectDetails = listOf()
    ),
    ProjectWithDetail(
        project = Project(
            id = 3,
            thumbnailRes = 0,
            name = "SCM",
            time = "2017-2018",
            language = "Java",
            introduction = ""
        ), projectDetails = listOf()
    ),
    ProjectWithDetail(
        project = Project(
            id = 4,
            thumbnailRes = R.drawable.doki_pal_1,
            name = "Doki Pal",
            time = "2018-2019",
            language = "Kotlin",
            introduction = "Doki pal is a smart watch designed for child. I participate in design, " +
                    "architect and implementation of the watch's software and it's companion android app."
        ), projectDetails = listOf(
            ProjectDetail(
                id = 1,
                projectId = 4,
                title =  "home",
                description = "",
                screenShotRes = R.drawable.doki_pal_1
            ),
            ProjectDetail(
                id = 1,
                projectId = 4,
                title =  "home",
                description = "",
                screenShotRes = R.drawable.doki_pal_2
            ),
            ProjectDetail(
                id = 2,
                projectId = 4,
                title =  "home",
                description = "",
                screenShotRes = R.drawable.doki_pal_3
            ),
            ProjectDetail(
                id = 3,
                projectId = 4,
                title =  "home",
                description = "",
                screenShotRes = R.drawable.doki_pal_4
            ),
            ProjectDetail(
                id = 4,
                projectId = 4,
                title =  "home",
                description = "",
                screenShotRes = R.drawable.doki_pal_5
            )
        )
    )
)