package gallery.duyakse04298.fpt.edu.com.project.fragment;


import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.graphics.Paint;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.adapter.BaseRecyclerViewAdapter;
import gallery.duyakse04298.fpt.edu.com.project.adapter.BaseSingleTypeRecyclerViewAdapter;
import gallery.duyakse04298.fpt.edu.com.project.databinding.FragmentDefaultMenuBinding;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ItemMenuDefaultBinding;
import gallery.duyakse04298.fpt.edu.com.project.view.DefaultDeviderItemDecoration;
import gallery.duyakse04298.fpt.edu.com.project.viewholder.BaseViewHolder;
import gallery.duyakse04298.fpt.edu.com.project.viewholder.DefaultMenuRecyclerViewHolder;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.FragmentDefaultMenuViewModel;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ItemViewModel;


public class DefaultMenuFragment extends BaseFragment<FragmentDefaultMenuBinding, FragmentDefaultMenuViewModel> {
    private ObservableList<ItemViewModel> listOb = new ObservableArrayList<>();
    private BaseSingleTypeRecyclerViewAdapter<ItemViewModel> adapter;


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
        if (listOb.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                listOb.add(new ItemViewModel(1 + i, "Capuchino Special Very Sweet", "T0001", "Coffee & Milk","45.000 đ", "35.000 đ", 654));
            }
        }
        initRecyclerView(context);
    }

    private void initRecyclerView(Context context){
        adapter = new BaseSingleTypeRecyclerViewAdapter<>(context, R.layout.item_menu_default);
        adapter.set(listOb);
        adapter.setPresenter(new ItemAdapterClickListener());
        adapter.setDecorator(new ItemDecorateListener());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        getBinding().setLayoutManager(layoutManager);
        getBinding().setVariable(BR.adapter, adapter);
        getBinding().rvDefaultMenu.setNestedScrollingEnabled(false);
        getBinding().rvDefaultMenu.addItemDecoration(new DefaultDeviderItemDecoration(context.getResources().getDrawable(R.drawable.divider_item_recycler_default)));
    }

    public class ItemAdapterClickListener implements BaseRecyclerViewAdapter.Presenter {
        public void onItemClick(String values) {
            android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
            DefaultItemFragment fragment = new DefaultItemFragment();
            fragment.show(fm,values);
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.flItemDetail, new DefaultItemFragment(),"findThisFragment");
//            ft.addToBackStack(null).commit();
        }
    }


    public class ItemDecorateListener implements BaseRecyclerViewAdapter.Decorator {
        @Override
        public void decorate(BaseViewHolder holder, int position, int viewType) {
            ItemMenuDefaultBinding menuDefaultBinding = (ItemMenuDefaultBinding) holder.getBinding();
            menuDefaultBinding.tvItemRetailPrice.setPaintFlags(menuDefaultBinding.tvItemRetailPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }


}
