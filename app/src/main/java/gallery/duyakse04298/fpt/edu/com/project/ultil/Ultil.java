package gallery.duyakse04298.fpt.edu.com.project.ultil;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

import gallery.duyakse04298.fpt.edu.com.project.databinding.ItemMenuDefaultBinding;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ItemViewModel;

/**
 * Created by Khuong Duy on 9/22/2017.
 */

public class Ultil {
    public static ArrayList<ItemViewModel> LIST_DUMMY = new ArrayList<ItemViewModel>() {{
        add(new ItemViewModel(1,"Coffe","T0001","Coffee & Milk","35.000 đ", 654));
        add(new ItemViewModel(2,"Coffe","T0001","Coffee & Milk","35.000 đ", 654));
        add(new ItemViewModel(3,"Coffe","T0001","Coffee & Milk","35.000 đ", 654));
    }};


    public static float convertDpToPixel(float dp, Context context) {
        Resources r = context.getResources();
        DisplayMetrics metrics = r.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
