package up.mash.gourmet_mash_up.item;

/**
 * Created by derba on 2018-08-01.
 */



public class FoodItem extends ItemwithType {

    public final int type = 0;
    private String imageLink;
    private String tradeName;
    private String menuName;
    private String locationName;
    private Boolean wish;
    private Boolean likeDislike;

    public int getType() {
        return type;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Boolean getWish() {
        return wish;
    }

    public void setWish(Boolean wish) {
        this.wish = wish;
    }

    public Boolean getLikeDislike() {
        return likeDislike;
    }

    public void setLikeDislike(Boolean likeDislike) {
        this.likeDislike = likeDislike;
    }
}
