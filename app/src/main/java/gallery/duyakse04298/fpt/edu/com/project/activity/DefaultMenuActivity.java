package gallery.duyakse04298.fpt.edu.com.project.activity;

import android.app.FragmentManager;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.adapter.BaseRecyclerViewAdapter;
import gallery.duyakse04298.fpt.edu.com.project.adapter.DefaultMenuViewPagerAdapter;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ActivityDefaultMenuBinding;
import gallery.duyakse04298.fpt.edu.com.project.fragment.DefaultItemFragment;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ActivityDefaultMenuViewModel;

public class DefaultMenuActivity extends BaseActivity<ActivityDefaultMenuBinding, ActivityDefaultMenuViewModel> implements View.OnClickListener{
    private static final String TAG = "DefaultMenuActivity";
    private int distanceScrolled;

    @Override
    public int getLayoutId() {
        return R.layout.activity_default_menu;
    }

    @Override
    public ActivityDefaultMenuViewModel setViewModel() {
        return new ActivityDefaultMenuViewModel();
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onCreateActivity() {
        overridePendingTransition(R.anim.smooth_slide_right_to_left_in, R.anim.smooth_slide_right_to_left_out);
        setStatusBarTranslucent(true);

        getBinding().ablDefaultMenu.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float alpha = ((float) -verticalOffset/ (float) getTopImageViewHeightInPixel());
                getBinding().vBackgroundDefaultMenuToolbar.setAlpha(alpha);
            }
        });
               DefaultMenuViewPagerAdapter adapter = new DefaultMenuViewPagerAdapter(getSupportFragmentManager());
        getBinding().vpDetailViewPager.setAdapter(adapter);
        getBinding().tlDetailViewPagerTab.setupWithViewPager(getBinding().vpDetailViewPager);
        getBinding().tlDetailViewPagerTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        getBinding().ivDefaultMenuBack.setOnClickListener(this);

    }


    public int getTopImageViewHeightInPixel() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int statusBarHeight = 0;
        int statusBarHeightId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (statusBarHeightId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(statusBarHeightId);
        }

        int searchBarHeight = getResources().getDimensionPixelSize(R.dimen.home_search_bar_height);

        return ((metrics.widthPixels * 3 / 5) - searchBarHeight - statusBarHeight);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivDefaultMenuBack:
                onBackPressed();
                break;
        }
    }

}
