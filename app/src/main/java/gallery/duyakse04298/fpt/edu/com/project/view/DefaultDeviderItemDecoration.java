package gallery.duyakse04298.fpt.edu.com.project.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import gallery.duyakse04298.fpt.edu.com.project.ultil.Ultil;

/**
 * Created by Khuong Duy on 9/28/2017.
 */

public class DefaultDeviderItemDecoration extends RecyclerView.ItemDecoration {
    final int PADDING_LEFT_RIGHT = 8;
    private Drawable drawable;

    public DefaultDeviderItemDecoration(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft() + Ultil.convertDpToPixelInt(PADDING_LEFT_RIGHT,parent.getContext());
        int right = parent.getWidth() - parent.getPaddingRight() - Ultil.convertDpToPixelInt(PADDING_LEFT_RIGHT,parent.getContext());

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int topDevider = child.getBottom() + params.bottomMargin;
            int bottomDivider = topDevider + drawable.getIntrinsicHeight();

            drawable.setBounds(left, topDevider, right, bottomDivider);
            drawable.draw(c);
        }
    }

}
