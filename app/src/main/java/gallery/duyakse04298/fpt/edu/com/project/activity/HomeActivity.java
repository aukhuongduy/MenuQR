package gallery.duyakse04298.fpt.edu.com.project.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ActivityHomeBinding;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ActivityHomeViewModel;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,ActivityHomeViewModel> {
    private ActivityHomeBinding binding ;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public ActivityHomeViewModel getViewModel() {
        return new ActivityHomeViewModel();
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onCreateActivity() {
        getSupportActionBar().hide();
        setStatusBarTranslucent(true);
    }

    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == requestCode && resultCode == RESULT_OK){
        }
    }
}
