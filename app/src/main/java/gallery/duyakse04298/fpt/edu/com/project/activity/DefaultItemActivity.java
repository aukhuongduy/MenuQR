package gallery.duyakse04298.fpt.edu.com.project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ActivityDefaultItemBinding;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.BaseViewModel;

public class DefaultItemActivity extends BaseActivity<ActivityDefaultItemBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_default_item;
    }

    @Override
    public BaseViewModel setViewModel() {
        return new BaseViewModel();
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onCreateActivity() {


    }
}
