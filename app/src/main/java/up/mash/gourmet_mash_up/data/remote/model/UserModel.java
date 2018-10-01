package up.mash.gourmet_mash_up.data.remote.model;

public class UserModel {

    private int id;
    private String username;
    private String introduce;
    private String profileImage;
    private int stampCount;
    private int followingCount;
    private int followerCount;
    private boolean isFollowing;
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

    public int getStampCount() {
        return stampCount;
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
}
