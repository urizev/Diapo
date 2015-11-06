package org.urizev.diapo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by jcvallejo on 5/11/15.
 */
public class ZoomImageView extends ImageView {
    public ZoomImageView(Context context) {
        this(context, null, 0);
    }

    public ZoomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZoomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ZoomImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
