package gallery.duyakse04298.fpt.edu.com.project.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by Khuong Duy on 9/19/2017.
 */

public class FourPerThreeFrameLayout extends FrameLayout {

    public FourPerThreeFrameLayout(Context context) {
        super(context);
    }

    public FourPerThreeFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FourPerThreeFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width*3/4);
    }
}
