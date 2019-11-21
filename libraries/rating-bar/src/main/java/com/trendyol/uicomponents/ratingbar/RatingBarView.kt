package com.trendyol.uicomponents.ratingbar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.trendyol.uicomponents.ratingbar.databinding.ViewRatingBarBinding

class RatingBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var starCount: Int = 0
    @ColorInt
    private var starHighlightColor: Int = Color.YELLOW
    @ColorInt
    private var starDefaultColor: Int = Color.GRAY
    @DrawableRes
    private var starDrawable: Int = R.drawable.ic_star

    private val binding: ViewRatingBarBinding = inflate(R.layout.view_rating_bar)

    init {
        context.theme?.obtainStyledAttributes(
            attrs,
            R.styleable.RatingBarView,
            defStyleAttr,
            0
        )?.apply {
            try {
                starCount = getInteger(R.styleable.RatingBarView_starCount, starCount)
                starHighlightColor =
                    getColor(
                        R.styleable.RatingBarView_starHighlightColor,
                        starHighlightColor
                    )
                starDefaultColor = getColor(
                    R.styleable.RatingBarView_starDefaultColor,
                    starDefaultColor
                )
                starDrawable = getResourceId(R.styleable.RatingBarView_starDrawable, starDrawable)

                updateViewState()
            } finally {
                recycle()
            }
        }
    }

    /**
     *
     * Sets star count to highlight with provided @param starHighlightColor
     *
     * @param starCount: starCount to highlight
     */
    fun setStarCount(starCount: Int) {
        this.starCount = starCount
        updateViewState()
    }

    /**
     * Sets star highlight color.
     *
     * @param color: Color for highlighted star.
     */
    fun setHighlightColor(@ColorInt color: Int) {
        this.starHighlightColor = color
        updateViewState()
    }

    /**
     *
     * Sets star default color. Stars that will not be highlighted, get this color.
     *
     * @param color: Color for star.
     */
    fun setDefaultStarColor(@ColorInt color: Int) {
        this.starDefaultColor = color
        updateViewState()
    }

    /**
     *
     * Sets custom star drawable.
     *
     * @param drawableResId: Id of an drawable.
     */
    fun setStarDrawable(@DrawableRes drawableResId: Int) {
        this.starDrawable = drawableResId
        updateViewState()
    }

    private fun createViewState(): RatingBarViewState = RatingBarViewState(
        starCount = starCount,
        starDefaultColor = starDefaultColor,
        starHighlightColor = starHighlightColor,
        starDrawable = starDrawable
    )

    private fun updateViewState() {
        binding.viewState = createViewState()
        binding.executePendingBindings()
    }
}
