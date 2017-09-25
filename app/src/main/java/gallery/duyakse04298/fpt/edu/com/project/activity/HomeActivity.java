package gallery.duyakse04298.fpt.edu.com.project.activity;

import android.animation.Animator;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;

import gallery.duyakse04298.fpt.edu.com.project.BR;
import gallery.duyakse04298.fpt.edu.com.project.R;
import gallery.duyakse04298.fpt.edu.com.project.databinding.ActivityHomeBinding;
import gallery.duyakse04298.fpt.edu.com.project.ultil.Ultil;
import gallery.duyakse04298.fpt.edu.com.project.viewmodel.ActivityHomeViewModel;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, ActivityHomeViewModel> implements View.OnClickListener {
    private boolean isSearching = false;
    private int distance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public ActivityHomeViewModel setViewModel() {
        return new ActivityHomeViewModel();
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onCreateActivity() {
        init();
    }

    private void init() {
        getSupportActionBar().hide();
        setStatusBarTranslucent(true);
        distance = getTranslateDistance();
        setEvent();

    }

    private void setEvent() {
        getBinding().edHomeSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View v, boolean hasFocus) {
                if (hasFocus) {
                    isSearching = true;
                    getBinding().flHomeSearch.animate().setDuration(300).translationY(-distance).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            // required
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            if (isSearching) {
                                getBinding().rlHomeListSearch.animate().setDuration(300).alpha(0).alphaBy(1).start();
                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            // required
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                            // required
                        }
                    });
                }

            }
        });
        getBinding().rlHomeScan.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (isSearching) {
            isSearching = false;
            getBinding().edHomeSearch.clearFocus();
            getBinding().flHomeSearch.clearAnimation();
            getBinding().rlHomeListSearch.clearAnimation();
            getBinding().flHomeSearch.animate().setDuration(300).translationY(0);
            getBinding().rlHomeListSearch.animate().setDuration(300).alpha(0).start();
        } else {
            super.onBackPressed();
        }
    }

    private int getTranslateDistance() {
        int translateDistance;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int statusBarHeight = 0;
        int statusBarHeightId = getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (statusBarHeightId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(statusBarHeightId);
        }

        int homeSearchBarMarginBottom = getResources().getDimensionPixelSize(R.dimen.home_search_bar_margin_bottom);

        int searchBarHeight = getResources().getDimensionPixelSize(R.dimen.home_search_bar_height);

        translateDistance = (metrics.widthPixels * 3 / 5) - searchBarHeight - statusBarHeight - homeSearchBarMarginBottom - (int) (Ultil.convertDpToPixel(4f, this));
        return translateDistance;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlHomeScan:
                Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}
