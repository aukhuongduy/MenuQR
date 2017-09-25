package gallery.duyakse04298.fpt.edu.com.project.ultil;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Khuong Duy on 9/22/2017.
 */

public class Ultil {

    public static float convertDpToPixel(float dp, Context context) {
        Resources r = context.getResources();
        DisplayMetrics metrics = r.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
