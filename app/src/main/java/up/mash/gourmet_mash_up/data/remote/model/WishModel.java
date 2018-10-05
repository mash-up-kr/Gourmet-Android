package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WishModel {

    @SerializedName("menu")
    @Expose
    private MenuModel menu;
    @SerializedName("restaurant")
    @Expose
    private RestaurantModel restaurant;

    @SerializedName("stamp")
    private String stampString;

    @SerializedName("wishId")
    private int wishId;
    @SerializedName("wishImageUrl")
    private String wishImageUrl;
    @SerializedName("wishedAt")
    private String wishedAt;
    // example: yyyy-MM-dd'T'HH:mm:ss

    public MenuModel getMenu() {
        return menu;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public String getStamp() {
        return stampString;
    }

    public int getWishId() {
        return wishId;
    }

    public String getWishImageUrl() {
        return wishImageUrl;
    }

    public String getWishedAt() {
        return wishedAt;
    }
}
