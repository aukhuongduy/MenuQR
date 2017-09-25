package gallery.duyakse04298.fpt.edu.com.project.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import gallery.duyakse04298.fpt.edu.com.project.R;

/**
 * Created by Khuong Duy on 9/21/2017.
 */

public class SquareRelaytiveLayout extends RelativeLayout implements View.OnTouchListener{
    public SquareRelaytiveLayout(Context context) {
        super(context);
        this.setOnTouchListener(this);
    }

    public SquareRelaytiveLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
    }

    public SquareRelaytiveLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int size;
        if (widthMode == MeasureSpec.EXACTLY && widthSize > 0) {
            size = widthSize;
        } else if (heightMode == MeasureSpec.EXACTLY && heightSize > 0) {
            size = heightSize;
        } else {
            size = widthSize < heightSize ? widthSize : heightSize;
        }

        int finalMeasureSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
        super.onMeasure(finalMeasureSpec, finalMeasureSpec);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getBackground().setColorFilter(getResources().getColor(R.color.colorAccentLightest), PorterDuff.Mode.SRC_ATOP);
                invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                getBackground().clearColorFilter();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                getBackground().clearColorFilter();
                invalidate();
        }
        return false;
    }
}
