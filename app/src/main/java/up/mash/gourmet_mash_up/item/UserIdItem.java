package up.mash.gourmet_mash_up.item;

/**
 * Created by derba on 2018-08-01.
 */

public class UserIdItem extends ItemwithType {

    public final int type = 1;
    private String userId;

    public int getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
