package gallery.duyakse04298.fpt.edu.com.project.fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.adapter.DefaultMenuViewPagerAdapter;
import gallery.duyakse04298.fpt.edu.com.project.adapter.ItemDetailViewPagerAdapter;
import gallery.duyakse04298.fpt.edu.com.project.databinding.FragmentDefaultItemBinding;
import gallery.duyakse04298.fpt.edu.com.project.ultil.Ultil;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.BaseViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefaultItemFragment extends BaseFragmentDialog<FragmentDefaultItemBinding, BaseViewModel> {

    public DefaultItemFragment() {
        // Required empty public constructor
    }


    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_default_item;
    }

    @Override
    public BaseViewModel setViewModel() {
        return new BaseViewModel();
    }

    @Override
    public void onCreateFragment(Context context) {
        ItemDetailViewPagerAdapter adapter = new ItemDetailViewPagerAdapter(getChildFragmentManager());
        getBinding().vpItemDetailDefaultMenu.setAdapter(adapter);
        getBinding().tlItemDetailDefaultMenu.setupWithViewPager(getBinding().vpItemDetailDefaultMenu);
    }

    @Override
    public void onResume() {
        super.onResume();
        int windowWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        int width = windowWidth - Ultil.convertDpToPixelInt(36, getContext());
        int height = width*16/9;
        getDialog().getWindow().setLayout(width, height);
    }
}
