package up.mash.gourmet_mash_up.item;

/**
 * Created by derba on 2018-08-01.
 */


public class FoodWish extends Food {

    private int like_percentage;
    private Boolean like_dislike;

    public int getLike_percentage() {
        return like_percentage;
    }

    public void setLike_percentage(int like_percentage) {
        this.like_percentage = like_percentage;
    }

    public Boolean getLike_dislike() {
        return like_dislike;
    }

    public void setLike_dislike(Boolean like_dislike) {
        this.like_dislike = like_dislike;
    }
}
