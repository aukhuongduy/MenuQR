package gallery.duyakse04298.fpt.edu.com.project.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Khuong Duy on 9/19/2017.
 */

public class FourPerThreeImageView extends android.support.v7.widget.AppCompatImageView {
    public FourPerThreeImageView(Context context) {
        super(context);
    }

    public FourPerThreeImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourPerThreeImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width*3/4);
    }

}
