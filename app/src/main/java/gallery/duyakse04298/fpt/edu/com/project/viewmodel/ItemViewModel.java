package gallery.duyakse04298.fpt.edu.com.project.viewmodel;

/**
 * Created by Khuong Duy on 9/27/2017.
 */

public class ItemViewModel extends BaseViewModel {
    private int itemId;
    private String itemName;
    private String itemCode;
    private String itemDescription;
    private String itemPrice;
    private int itemViewed;

    public ItemViewModel(int itemId) {
        this.itemId = itemId;
    }

    public ItemViewModel(int itemId, String itemName, String itemCode, String itemDescription, String itemPrice, int itemViewed) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemViewed = itemViewed;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemViewed() {
        return itemViewed;
    }

    public String getItemViewedString() {
        return itemViewed + "";
    }

    public void setItemViewed(int itemViewed) {
        this.itemViewed = itemViewed;
    }
}
