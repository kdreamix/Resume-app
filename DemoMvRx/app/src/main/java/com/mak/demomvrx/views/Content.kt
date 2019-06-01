package com.mak.demomvrx.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.airbnb.paris.annotations.Style
import com.airbnb.paris.annotations.Styleable
import com.airbnb.paris.extensions.contentStyle
import com.airbnb.paris.extensions.paddingEndDp
import com.airbnb.paris.extensions.paddingStartDp
import com.mak.demomvrx.R

@Styleable
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Content @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val contentView by lazy { findViewById<TextView>(R.id.content) }

    init {
        inflate(context, R.layout.content, this)
    }

    @TextProp
    fun setContent(content: CharSequence?) {
        contentView.text = content
    }

    companion object {

        @Style(isDefault = true)
        val CONTENT_STYLE = contentStyle {
            paddingStartDp(0)
            paddingEndDp(0)
        }

        @Style
        val CONTENT_WITH_PADDING_STYLE = contentStyle {
            paddingStartDp(16)
            paddingEndDp(16)
        }
    }
}