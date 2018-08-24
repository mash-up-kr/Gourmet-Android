package up.mash.gourmet_mash_up.model.local;

public class Stamp {

    private String where;
    private String what;
    private String address;

    public Stamp(String where, String what, String address) {
        this.where = where;
        this.what = what;
        this.address = address;
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
