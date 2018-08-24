package up.mash.gourmet_mash_up.item;

import java.util.Date;

/**
 * Created by derba on 2018-08-24.
 */

public class ReviewItem
{
    private String imageSrc;
    private String userId;
    private String review;
    private Date date;
    private Boolean like_or_dislike;

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getLike_or_dislike() {
        return like_or_dislike;
    }

    public void setLike_or_dislike(Boolean like_or_dislike) {
        this.like_or_dislike = like_or_dislike;
    }
}
