package gallery.duyakse04298.fpt.edu.com.project.fragment;


import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.adapter.BaseRecyclerViewAdapter;
import gallery.duyakse04298.fpt.edu.com.project.adapter.BaseSingleTypeRecyclerViewAdapter;
import gallery.duyakse04298.fpt.edu.com.project.databinding.FragmentDefaultMenuBinding;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ItemMenuDefaultBinding;
import gallery.duyakse04298.fpt.edu.com.project.ultil.Ultil;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.FragmentDefaultMenuViewModel;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ItemViewModel;


public class DefaultMenuFragment extends BaseFragment<FragmentDefaultMenuBinding, FragmentDefaultMenuViewModel> {
    private ObservableList<ItemViewModel> listOb = new ObservableArrayList<>();


    public DefaultMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_default_menu;
    }

    @Override
    public FragmentDefaultMenuViewModel setViewModel() {
        return new FragmentDefaultMenuViewModel();
    }

    @Override
    public void onCreateFragment(Context context) {
        for (int i = 0; i < 10; i++) {
            listOb.add(new ItemViewModel(1 + i, "Coffee", "T0001", "Coffee & Milk", "35.000 đ", 654));
        }
        BaseSingleTypeRecyclerViewAdapter<ItemViewModel> adapter = new BaseSingleTypeRecyclerViewAdapter<>(context, R.layout.item_menu_default);
        adapter.addAll(listOb);
        adapter.setPresenter(new ItemAdapterClickListener());
        getBinding().setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        getBinding().setVariable(BR.adapter, adapter);

    }

    public class ItemAdapterClickListener implements BaseRecyclerViewAdapter.Presenter {
        public void onItemClick(String values) {
            Toast.makeText(getActivity(), values, Toast.LENGTH_SHORT).show();
        }
    }


}
