package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class MenuModel {

    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("price")
    int price;
    @SerializedName("registeredTime")
    String registeredTime;

    @SerializedName("wished")
    boolean wished;

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
