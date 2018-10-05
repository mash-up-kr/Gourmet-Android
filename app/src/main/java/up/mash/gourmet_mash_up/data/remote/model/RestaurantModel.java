package up.mash.gourmet_mash_up.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class RestaurantModel {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("latitude")
    private long latitude;
    @SerializedName("longitude")
    private long longitude;
    @SerializedName("address")
    private String address;
    @SerializedName("registeredTime")
    private String registeredTime;

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }
}
