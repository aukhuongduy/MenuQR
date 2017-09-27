package gallery.duyakse04298.fpt.edu.com.project.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import gallery.duyakse04298.fpt.edu.com.project.viewmodel.BaseViewModel;

/**
 * Created by Khuong Duy on 9/26/2017.
 */

public class BaseViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T binding;

    public BaseViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }
}
