package up.mash.gourmet_mash_up.item;

public class RankItem {
    private int rankingNumber;
    private String url;
    private String userId;
    private String stampCount;
    private String userFollowerCount;

    public int getRankingNumber() {
        return rankingNumber;
    }

    public void setRankingNumber(int rankingNumber) {
        this.rankingNumber = rankingNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStampCount() {
        return stampCount;
    }

    public void setStampCount(String stampCount) {
        this.stampCount = stampCount;
    }

    public String getUserFollowerCount() {
        return userFollowerCount;
    }

    public void setUserFollowerCount(String userFollowerCount) {
        this.userFollowerCount = userFollowerCount;
    }
}
