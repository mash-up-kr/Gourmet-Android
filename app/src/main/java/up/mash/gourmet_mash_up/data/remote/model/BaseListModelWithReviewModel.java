package up.mash.gourmet_mash_up.data.remote.model;

public class BaseListModelWithReviewModel {

    private int count;
    private ReviewModel data;
    private int nextpage;
    private int totalCount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ReviewModel getData() {
        return data;
    }

    public void setData(ReviewModel data) {
        this.data = data;
    }

    public int getNextpage() {
        return nextpage;
    }

    public void setNextpage(int nextpage) {
        this.nextpage = nextpage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
