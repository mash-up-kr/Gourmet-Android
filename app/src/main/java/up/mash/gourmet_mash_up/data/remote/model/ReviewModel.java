package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewModel {

    @SerializedName("id")
    private int id;
    @SerializedName("stamp")
    private String stamp;

    @SerializedName("author")
    @Expose
    private UserModel author;

    @SerializedName("restaurant")
    @Expose
    private RestaurantModel restaurant;

    @SerializedName("menu")
    @Expose
    private MenuModel menu;

    @SerializedName("menuTastes")
    private String[] menuTaste;

    @SerializedName("reviewImageUrl")
    private String reviewImageUrl;

    public int getId() {
        return id;
    }

    public String getStamp() {
        return stamp;
    }

    public UserModel getAuthor() {
        return author;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public MenuModel getMenu() {
        return menu;
    }

    public String[] getMenuTaste() {
        return menuTaste;
    }

    public void setMenuTaste(String[] menuTaste) {
        this.menuTaste = menuTaste;
    }

    public String getReviewImageUrl() {
        return reviewImageUrl;
    }
}
