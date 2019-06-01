package com.mak.demomvrx.models

import com.mak.demomvrx.R

const val projectType = "Projects"
const val sideProjectType = "Side Projects"
const val schoolProjectType = "School Projects"

val outback = ProjectWithDetail(
    project = Project(
        id = 1,
        thumbnailRes = 0,
        name = "Outback",
        time = "2017-2018",
        language = "Java",
        introduction = "",
        projectType = projectType
    ), projectDetails = listOf()
)

val iDefect = ProjectWithDetail(
    project = Project(
        id = 2,
        thumbnailRes = 0,
        name = "IDefect",
        time = "2017-2018",
        language = "Kotlin",
        introduction = "",
        projectType = projectType

    ), projectDetails = listOf()
)

val SCM = ProjectWithDetail(
    project = Project(
        id = 3,
        thumbnailRes = 0,
        name = "SCM",
        time = "2017-2018",
        language = "Java",
        introduction = "",
        projectType = projectType
    ), projectDetails = listOf()
)

val dokiPal = ProjectWithDetail(
    project = Project(
        id = 4,
        thumbnailRes = R.drawable.doki_pal_1,
        name = "Doki Pal",
        time = "2018-2019",
        language = "Kotlin",
        introduction = "Doki pal is a smart watch designed for child. I participate in design, " +
                "architect and implementation of the watch's software and it's companion android app.",
        projectType = projectType
    ), projectDetails = listOf(
        ProjectDetail(
            id = 1,
            projectId = 4,
            title = "home",
            description = "",
            screenShotRes = R.drawable.doki_pal_1
        ),
        ProjectDetail(
            id = 1,
            projectId = 4,
            title = "home",
            description = "",
            screenShotRes = R.drawable.doki_pal_2
        ),
        ProjectDetail(
            id = 2,
            projectId = 4,
            title = "home",
            description = "",
            screenShotRes = R.drawable.doki_pal_3
        ),
        ProjectDetail(
            id = 3,
            projectId = 4,
            title = "home",
            description = "",
            screenShotRes = R.drawable.doki_pal_4
        ),
        ProjectDetail(
            id = 4,
            projectId = 4,
            title = "home",
            description = "",
            screenShotRes = R.drawable.doki_pal_5
        )
    )
)

val airButton = ProjectWithDetail(
    project = Project(
        id = 5,
        thumbnailRes = 0,
        name = "Air Button",
        time = "2016",
        language = "Java",
        introduction = "",
        projectType = schoolProjectType
    ), projectDetails = listOf()
)

val FYP = ProjectWithDetail(
    project = Project(
        id = 5,
        thumbnailRes = 0,
        name = "FYP",
        time = "2017",
        language = "C++, Python",
        introduction = "",
        projectType = schoolProjectType
    ), projectDetails = listOf()
)