package up.mash.gourmet_mash_up.data.remote.model;

public class User {

    private int id;
    private String userName;
    private String introduce;
    private String profileImage;
    private int stampCount;
    private int wishCount;
    private int followingCount;
    private int followerCount;
    private boolean isFollowing;
    private boolean isPublic;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public int getStampCount() {
        return stampCount;
    }

    public int getWishCount() {
        return wishCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public boolean isPublic() {
        return isPublic;
    }
}
