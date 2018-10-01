package up.mash.gourmet_mash_up.data.remote.model;

public class WishModel {

    private MenuModel menu;
    private RestaurantModel restaurant;
    private ReviewModel review;
    private int wishId;
    private String wishedAt;
    // example: yyyy-MM-dd'T'HH:mm:ss


    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantModel restaurant) {
        this.restaurant = restaurant;
    }

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public String getWishedAt() {
        return wishedAt;
    }

    public void setWishedAt(String wishedAt) {
        this.wishedAt = wishedAt;
    }
}
