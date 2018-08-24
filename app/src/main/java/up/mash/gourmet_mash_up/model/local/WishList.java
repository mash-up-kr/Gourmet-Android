package up.mash.gourmet_mash_up.model.local;

public class WishList {

    private String where;
    private String what;
    private String address;

    private static WishList instance;

    public static WishList getIntance() {
        if (instance == null) {
            instance = new WishList();
        }
        return instance;
    }

    private WishList() {
        this.where = "";
        this.what = "";
        this.address = "";
    }

    public void clear() {
        this.where = "";
        this.what = "";
        this.address = "";
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
