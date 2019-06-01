package com.mak.demomvrx.views

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.mak.demomvrx.R
import com.mak.demomvrx.core.extensions.dpToPx
import com.mak.demomvrx.models.ProjectWithDetail

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ProjectThumbnail @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val thumbnailImage: ImageView
    private val thumbnailText: TextView
    private val thumbnailTimeText: TextView
    private val languageChip: Chip

    @ModelProp
    fun setModel(projectWithDetail: ProjectWithDetail) = with(projectWithDetail.project) {
        thumbnailImage.setColorFilter(ContextCompat.getColor(context,R.color.primaryColor), PorterDuff.Mode.MULTIPLY)
        Glide.with(thumbnailImage)
            .load(this.thumbnailRes)
            .thumbnail(/*sizeMultiplier=*/ 0.25f)
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
//                    Palette.from(resource.toBitmap()).generate {
//                        val darkMutedColor = it?.getDarkMutedColor(ContextCompat.getColor(context, R.color.surface))
//                        darkMutedColor?.let { it1 ->  }
//                    }
                    return false
                }

            })
            .into(thumbnailImage)


        thumbnailText.text = name
        thumbnailTimeText.text = time
        languageChip.text = language
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }


    init {
        inflate(context, R.layout.thumbnail, this)
        thumbnailImage = findViewById(R.id.thumbnailImage)
        thumbnailText = findViewById(R.id.thumbnailText)
        languageChip = findViewById(R.id.languageChip)
        thumbnailTimeText = findViewById(R.id.thumbnailTimeText)
        radius = 12.dpToPx()
        cardElevation = 1.dpToPx()
        elevation = 1.dpToPx()
        setCardBackgroundColor(ContextCompat.getColor(context, R.color.surface))
        strokeColor = ContextCompat.getColor(this.context, R.color.secondaryLightColor)
    }
}