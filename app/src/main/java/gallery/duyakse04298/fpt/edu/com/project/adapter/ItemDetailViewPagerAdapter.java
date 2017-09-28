package gallery.duyakse04298.fpt.edu.com.project.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import gallery.duyakse04298.fpt.edu.com.project.fragment.BaseFragment;
import gallery.duyakse04298.fpt.edu.com.project.fragment.ItemInfoFragment;
import gallery.duyakse04298.fpt.edu.com.project.fragment.ItemIngredientFragment;
import gallery.duyakse04298.fpt.edu.com.project.fragment.ItemNutritionFragment;

/**
 * Created by Khuong Duy on 9/29/2017.
 */

public class ItemDetailViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> list = new ArrayList<>();

    public ItemDetailViewPagerAdapter(FragmentManager fm) {
        super(fm);
        ItemInfoFragment infoFragment = new ItemInfoFragment();
        infoFragment.setFragmentTitle("Infomation");
        list.add(infoFragment);

        ItemIngredientFragment ingredientFragment = new ItemIngredientFragment();
        ingredientFragment.setFragmentTitle("Ingredient");
        list.add(ingredientFragment);

        ItemNutritionFragment nutritionFragment = new ItemNutritionFragment();
        nutritionFragment.setFragmentTitle("Nutrition");
        list.add(nutritionFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getFragmentTitle();
    }
}
