package gallery.duyakse04298.fpt.edu.com.project.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gallery.duyakse04298.fpt.edu.com.project.viewmodel.BaseViewModel;

/**
 * Created by Khuong Duy on 9/20/2017.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {
    private T binding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatabinding();
        onCreateActivity();
    }

    private void initDatabinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = viewModel == null ? getViewModel() : viewModel;
        binding.setVariable(getVariableId(), viewModel);
    }

    public abstract int getLayoutId();

    public abstract V getViewModel();

    public abstract int getVariableId();

    public abstract void onCreateActivity();
}
