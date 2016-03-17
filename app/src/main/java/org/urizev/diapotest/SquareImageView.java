package org.urizev.diapotest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by jcvallejo at 9/3/16.
 */
public class SquareImageView extends ImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int wMode = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getMode(heightMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int w = wSize;
        int h = hSize;

        if (wMode != MeasureSpec.UNSPECIFIED && hMode != MeasureSpec.UNSPECIFIED) {
            w = h = Math.min(wSize, hSize);
        } else if (wMode != MeasureSpec.UNSPECIFIED) {
            w = h = wSize;
        } else if (hMode != MeasureSpec.UNSPECIFIED) {
            w = h = hSize;
        }

        setMeasuredDimension(w, h);
    }
}
