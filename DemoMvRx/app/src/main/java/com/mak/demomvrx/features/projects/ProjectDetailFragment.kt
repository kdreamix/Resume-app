package com.mak.demomvrx.features.projects

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.mvrx.args
import com.airbnb.mvrx.fragmentViewModel
import com.mak.demomvrx.core.base.BaseFragment
import com.mak.demomvrx.core.base.MvRxEpoxyController
import com.mak.demomvrx.core.base.simpleController
import com.mak.demomvrx.core.extensions.dpToPx
import com.mak.demomvrx.models.findProject
import com.mak.demomvrx.views.Content.Companion.CONTENT_WITH_PADDING_STYLE
import com.mak.demomvrx.views.Marquee.Companion.paddingStyle
import com.mak.demomvrx.views.content
import com.mak.demomvrx.views.grid
import com.mak.demomvrx.views.marquee
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProjectDetailArgs(val id: Int) : Parcelable

class ProjectDetailFragment : BaseFragment() {
    private val viewModel: ProjectViewModel by fragmentViewModel()
    private val args: ProjectDetailArgs by args()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spanCount = 3
        val layoutManager = GridLayoutManager(context, spanCount).apply {
            spanSizeLookup = epoxyController.spanSizeLookup
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.updatePadding(top =  1.dpToPx().toInt(),left = 0,right = 0)
        recyclerView.setItemSpacingDp(1)
    }
    override fun epoxyController(): MvRxEpoxyController = simpleController(viewModel) { state ->
        state.projects.findProject(args.id)?.let { projectWithDetail->

            projectWithDetail.projectDetails.forEach {
                grid {
                    id(it.id)
                    model(it)
                    spanSizeOverride { _, _, _ -> 1 }
                }
            }

            marquee {
                id("header")
                title(projectWithDetail.project.name)
                spanSizeOverride { _, _, _ -> 3 }
                style(paddingStyle)
            }

            content {
                id("content")
                content(projectWithDetail.project.introduction)
                spanSizeOverride { _, _, _ -> 3 }
                style(CONTENT_WITH_PADDING_STYLE)
            }
        }


    }


}