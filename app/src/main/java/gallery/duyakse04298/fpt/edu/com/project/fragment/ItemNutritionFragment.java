package gallery.duyakse04298.fpt.edu.com.project.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.databinding.FragmentItemNutritionBinding;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ItemNutritionFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemNutritionFragment extends BaseFragment<FragmentItemNutritionBinding, ItemNutritionFragmentViewModel> {


    public ItemNutritionFragment() {
        // Required empty public constructor
    }


    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item_nutrition;
    }

    @Override
    public ItemNutritionFragmentViewModel setViewModel() {
        return new ItemNutritionFragmentViewModel(getContext());
    }

    @Override
    public void onCreateFragment(Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        getBinding().setLayoutManager(layoutManager);

    }
}
