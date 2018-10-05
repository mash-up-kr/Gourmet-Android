package up.mash.gourmet_mash_up.data.local;

import java.io.File;

public class WishList {

    private String where;
    private String what;
    private String address;
    private File imageFile;

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
        if(this.imageFile.exists()){
            this.imageFile.delete();
        }
    }

    public File getImageFile() {
        return imageFile;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
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
