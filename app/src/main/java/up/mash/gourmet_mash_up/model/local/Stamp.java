package up.mash.gourmet_mash_up.model.local;

public class Stamp {

    private String where;
    private String what;
    private String how;

    private static Stamp instance;

    public static Stamp getIntance() {
        if (instance == null) {
            instance = new Stamp();
        }
        return instance;
    }

    private Stamp() {
        this.where = "";
        this.what = "";
        this.how = "";
    }

    public void clear() {
        this.where = "";
        this.what = "";
        this.how = "";
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

    public String getHow() {
        return how;
    }

    public void setHow(String address) {
        this.how = address;
    }
}
