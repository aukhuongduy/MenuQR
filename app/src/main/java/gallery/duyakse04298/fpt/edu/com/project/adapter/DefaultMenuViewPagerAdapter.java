package gallery.duyakse04298.fpt.edu.com.project.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import gallery.duyakse04298.fpt.edu.com.project.activity.DefaultMenuActivity;
import gallery.duyakse04298.fpt.edu.com.project.fragment.BaseFragment;
import gallery.duyakse04298.fpt.edu.com.project.fragment.DefaultMenuFragment;

/**
 * Created by Khuong Duy on 9/25/2017.
 */

public class DefaultMenuViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> list = new ArrayList<>();

    public DefaultMenuViewPagerAdapter(FragmentManager fm) {
        super(fm);
        DefaultMenuFragment fragment1 = new DefaultMenuFragment();
        fragment1.setFragmentTitle("Drink");
        DefaultMenuFragment fragment2 = new DefaultMenuFragment();
        fragment2.setFragmentTitle("Food");
        DefaultMenuFragment fragment3 = new DefaultMenuFragment();
        fragment3.setFragmentTitle("Vegetarian");
        DefaultMenuFragment fragment4 = new DefaultMenuFragment();
        fragment4.setFragmentTitle("LowCarb");
        DefaultMenuFragment fragment5 = new DefaultMenuFragment();
        fragment5.setFragmentTitle("Wine");
        DefaultMenuFragment fragment6 = new DefaultMenuFragment();
        fragment6.setFragmentTitle("Combo");
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);
        list.add(fragment6);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getFragmentTitle();
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
