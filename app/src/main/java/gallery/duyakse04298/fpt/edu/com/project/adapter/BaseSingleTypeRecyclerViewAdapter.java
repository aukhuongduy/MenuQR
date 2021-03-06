package gallery.duyakse04298.fpt.edu.com.project.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gallery.duyakse04298.fpt.edu.com.project.viewholder.BaseViewHolder;

/**
 * Created by Khuong Duy on 9/27/2017.
 */

public class BaseSingleTypeRecyclerViewAdapter<T> extends BaseRecyclerViewAdapter<T> {
    protected int layoutId;

    public BaseSingleTypeRecyclerViewAdapter(Context context, int layoutId) {
        super(context);
        this.layoutId = layoutId;
        listItem = new ArrayList<>();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder(DataBindingUtil.inflate(getLayoutInflater(), layoutId, parent, false));
    }

    public void add(T viewModel){
        listItem.add(viewModel);
        notifyDataSetChanged();
    }

    public void add(int position,T viewModel){
        listItem.add(position, viewModel);
        notifyDataSetChanged();
    }

    public void addAll(List<T> listViewModel){
        listItem.addAll(listViewModel);
        notifyDataSetChanged();
    }

    public void set(List<T> listViewModel){
        listItem = listViewModel;
        notifyDataSetChanged();
    }
    @LayoutRes
    public int getLayoutId() {
        return layoutId;
    }

    // define type event
    public interface Presenter<T> extends BaseRecyclerViewAdapter.Presenter {
        void onItemClick(T t);
    }
}
