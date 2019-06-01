package com.mak.demomvrx.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.airbnb.paris.annotations.Style
import com.airbnb.paris.annotations.Styleable
import com.airbnb.paris.extensions.*
import com.mak.demomvrx.R

@Styleable
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Marquee @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val titleView by lazy { findViewById<TextView>(R.id.title) }

    init {
        inflate(context, R.layout.header, this)
    }

    @TextProp
    fun setTitle(title: CharSequence?) {
        titleView.text = title
    }

    companion object {
        @Style(isDefault = true)
        val h4Style = marqueeStyle {
            paddingStartDp(0)
            paddingEndDp(0)
            paddingTopDp(0)
            paddingBottomDp(0)
        }

        @Style
        val paddingStyle = marqueeStyle {
            paddingStartDp(16)
            paddingEndDp(16)
            paddingTopDp(16)
            paddingBottomDp(16)
        }
    }

}