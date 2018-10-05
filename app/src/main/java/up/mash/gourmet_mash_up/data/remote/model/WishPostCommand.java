package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class WishPostCommand {

    public WishPostCommand(MenuPostCommand menu, RestaurantPostCommand restaurantPostCommand) {
        mMenu = menu;
        mRestaurantPostCommand = restaurantPostCommand;
    }

    @SerializedName("menu")
    private
    MenuPostCommand mMenu;

    @SerializedName("restaurant")
    private
    RestaurantPostCommand mRestaurantPostCommand;

    public MenuPostCommand getMenu() {
        return mMenu;
    }

    public RestaurantPostCommand getRestaurantPostCommand() {
        return mRestaurantPostCommand;
    }
}
