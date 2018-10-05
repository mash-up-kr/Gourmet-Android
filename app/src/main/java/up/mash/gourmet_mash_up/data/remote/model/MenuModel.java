package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class MenuModel {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private int price;
    @SerializedName("registeredTime")
    private String registeredTime;
    @SerializedName("wished")
    private boolean wished;

    public boolean isWished() {
        return wished;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }
}
