package up.mash.gourmet_mash_up.data.remote.model;

public class ReviewPostCommand {

    private String command;
    private MenuPostCommand menu;
    private RestaurantPostCommand restaurant;
    private String stamp; //[ LIKE, DISLIKE ]
    private int wishId;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public MenuPostCommand getMenu() {
        return menu;
    }

    public void setMenu(MenuPostCommand menu) {
        this.menu = menu;
    }

    public RestaurantPostCommand getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantPostCommand restaurant) {
        this.restaurant = restaurant;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }
}
