package gallery.duyakse04298.fpt.edu.com.project.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.databinding.FragmentItemInfoBinding;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.BaseViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemInfoFragment extends BaseFragment<FragmentItemInfoBinding, BaseViewModel> {


    public ItemInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item_info;
    }

    @Override
    public BaseViewModel setViewModel() {
        return new BaseViewModel();
    }

    @Override
    public void onCreateFragment(Context context) {

    }
}
