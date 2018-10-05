package up.mash.gourmet_mash_up.data.remote.model;

import java.util.List;

public class BaseListModelWithReviewModel {

    private int count;
    private List<ReviewModel> data;
    private int nextpage;
    private int totalCount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ReviewModel> getData() {
        return data;
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
