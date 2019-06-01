package com.mak.demomvrx.features.projects

import com.airbnb.mvrx.*
import com.mak.demomvrx.core.base.MvRxViewModel
import com.mak.demomvrx.database.ProjectDao
import com.mak.demomvrx.models.ProjectWithDetail
import com.mak.demomvrx.models.populate
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

data class ProjectListState(
    val projects: List<ProjectWithDetail> = emptyList(),
    val request: Async<List<ProjectWithDetail>> = Uninitialized

) : MvRxState

class ProjectViewModel(initialState: ProjectListState, private val projectDao: ProjectDao) :
    MvRxViewModel<ProjectListState>(initialState) {

    init {
//        projectDao.insertAll(populate())
        fetchProjects()
    }

    private fun fetchProjects() = withState { state ->
        if (state.request is Loading) return@withState
//        projectDao
//            .getAllProjects()
        Observable.just(populate())
            .subscribeOn(Schedulers.io())
//            .toObservable()
            .execute { copy(request = it, projects = it() ?: emptyList()) }

    }

    companion object : MvRxViewModelFactory<ProjectViewModel, ProjectListState> {

        override fun create(viewModelContext: ViewModelContext, state: ProjectListState): ProjectViewModel {
            val projectDao: ProjectDao by viewModelContext.activity.inject()
            return ProjectViewModel(state, projectDao)
        }
    }
}