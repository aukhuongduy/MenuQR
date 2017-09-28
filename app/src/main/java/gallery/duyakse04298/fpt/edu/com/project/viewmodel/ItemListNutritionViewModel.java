package gallery.duyakse04298.fpt.edu.com.project.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;

import gallery.duyakse04298.fpt.edu.com.project.R;

/**
 * Created by Khuong Duy on 9/29/2017.
 */

public class ItemListNutritionViewModel extends BaseViewModel{
    private Context context;
    private String name;
    private double value;
    private String dram;

    public ItemListNutritionViewModel(String name, double value, String dram, Context context) {
        this.name = name;
        this.value = value;
        this.dram = dram;
        this.context =context;
    }

    public Drawable getStatus(){
        if(value < 50){
            return context.getResources().getDrawable(R.drawable.circle_green);
        }else if(value <100){
            return context.getResources().getDrawable(R.drawable.circle_orange);
        }else {
            return context.getResources().getDrawable(R.drawable.circle_red);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueString(){
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDram() {
        return dram;
    }

    public void setDram(String dram) {
        this.dram = dram;
    }
}
