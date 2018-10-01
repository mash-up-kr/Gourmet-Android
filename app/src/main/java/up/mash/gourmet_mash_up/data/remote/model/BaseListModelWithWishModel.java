package up.mash.gourmet_mash_up.data.remote.model;

public class BaseListModelWithWishModel {

    private int count;
    private WishModel data;
    private int nextpage;
    private int totalCount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public WishModel getData() {
        return data;
    }

    public void setData(WishModel data) {
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
