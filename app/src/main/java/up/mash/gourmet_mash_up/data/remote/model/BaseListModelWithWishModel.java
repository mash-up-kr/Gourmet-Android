package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseListModelWithWishModel {

    @SerializedName("count")
    private int count;
    @SerializedName("data")
    private List<WishModel> data;
    @SerializedName("nextPage")
    private int nextPage;
    @SerializedName("totalCount")
    private int totalCount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<WishModel> getData() {
        return data;
    }

    public void setData(List<WishModel> data) {
        this.data = data;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
