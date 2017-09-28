package gallery.duyakse04298.fpt.edu.com.project.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;

import java.util.List;

import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.adapter.BaseSingleTypeRecyclerViewAdapter;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ItemListNutritionBinding;

/**
 * Created by Khuong Duy on 9/29/2017.
 */

public class ItemNutritionFragmentViewModel extends BaseViewModel {
    ObservableArrayList<ItemListNutritionViewModel> listItem = new ObservableArrayList<>();
    BaseSingleTypeRecyclerViewAdapter<ItemListNutritionViewModel> adapter;
    public ItemNutritionFragmentViewModel(Context context) {
        listItem.add(new ItemListNutritionViewModel("Calories",360,"Kcal",context));
        listItem.add(new ItemListNutritionViewModel("Fat",60,"mg",context));
        listItem.add(new ItemListNutritionViewModel("Canxi",9,"mg",context));
        listItem.add(new ItemListNutritionViewModel("Kali",8,"mg",context));
        adapter = new BaseSingleTypeRecyclerViewAdapter<>(context, R.layout.item_list_nutrition);
        adapter.set(listItem);
    }

    public BaseSingleTypeRecyclerViewAdapter<ItemListNutritionViewModel> getAdapter() {
        return adapter;
    }
}
