package com.mak.demomvrx.features.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.mak.demomvrx.core.base.BaseFragment
import com.mak.demomvrx.core.base.MvRxEpoxyController
import com.mak.demomvrx.core.base.simpleController
import com.mak.demomvrx.views.projectThumbnail
import androidx.recyclerview.widget.GridLayoutManager
import com.mak.demomvrx.R
import com.mak.demomvrx.views.content
import com.mak.demomvrx.views.marquee
import com.mak.demomvrx.views.space
import com.airbnb.mvrx.activityViewModel as activityViewModel1


class ProjectListFragment : BaseFragment() {

    private val viewModel: ProjectViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spanCount = 2
        val layoutManager = GridLayoutManager(context, spanCount).apply {
            spanSizeLookup = epoxyController.spanSizeLookup
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.setItemSpacingDp(8)
    }

    override fun epoxyController(): MvRxEpoxyController = simpleController(viewModel) { state ->
        marquee {
            id("AboutTitle")
            title("Me")
            spanSizeOverride { _, _, _ -> 2 }
        }
        space {
            id("s1")
        }
        content {
            id("AboutContent")
            content("Hi, I am Kit. A developer focuses on mobile development. Currently being an enthusiast of Kotlin. Love to try and learn new things.")
            spanSizeOverride { _, _, _ -> 2 }
        }
        space {
            id("s2")
        }

        state.projects
            .groupBy { it.project.projectType }
            .forEach {
                space {
                    id("space",it.key)
                }
                marquee {
                    id(it.key)
                    title(it.key)
                    spanSizeOverride { _, _, _ -> 2 }
                }
                it.value.forEach {
                    projectThumbnail {
                        id(it.project.id)
                        model(it)
                        clickListener { model, parentView, clickedView, position ->
                            navigateTo(
                                actionId = R.id.actionOpenDetail,
                                arg = ProjectDetailArgs(model.model().project.id)
                            )
                        }
                        spanSizeOverride { _, _, _ -> 1 }
                    }
                }

            }


        space {
            id("s3")
        }
        marquee {
            id("ProjectTitle")
            title("Side Project")
            spanSizeOverride { _, _, _ -> 2 }
        }
    }

}