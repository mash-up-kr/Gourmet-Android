package up.mash.gourmet_mash_up.data.remote.model;

public class ReviewModel {

    private int id;
    private String stamp;
    private UserModel author;
    private RestaurantModel restaurant;
    private MenuModel menu;
    private String menuTaste;
    private String menuImages;
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

    public String getMenuTaste() {
        return menuTaste;
    }

    public String getMenuImages() {
        return menuImages;
    }
}
