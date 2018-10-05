package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("introduce")
    private String introduce;

    @SerializedName("profileImage")
    private String profileImage;

    @SerializedName("stampCount")
    private int stampCount;

    @SerializedName("wishCount")
    private int wishCount;

    @SerializedName("followingCount")
    private int followingCount;

    @SerializedName("followerCount")
    private int followerCount;

    @SerializedName("isPublic")
    private boolean isPublic;

    public boolean isPublic() {
        return isPublic;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }
    public int getStampCount() {
        return stampCount;
    }

    public int getWishCount() {
        return wishCount;
    }
}
