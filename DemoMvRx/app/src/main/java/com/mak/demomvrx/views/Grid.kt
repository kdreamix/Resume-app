package com.mak.demomvrx.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide
import com.mak.demomvrx.R
import com.mak.demomvrx.models.ProjectDetail

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Grid @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val screenShot: ImageView

    @ModelProp
    fun setModel(projectDetail: ProjectDetail) = with(projectDetail){
        Glide.with(screenShot)
            .load(screenShotRes)
            .thumbnail(/*sizeMultiplier=*/ 0.25f)
            .centerCrop()
            .into(screenShot)
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }


    init {
        inflate(context, R.layout.grid, this)
        screenShot = findViewById(R.id.gridScreenShot)
    }
}