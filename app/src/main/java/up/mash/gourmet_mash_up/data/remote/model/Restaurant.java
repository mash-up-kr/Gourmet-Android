package up.mash.gourmet_mash_up.data.remote.model;

public class Restaurant {

    private int id;
    private String name;
    private long latitude;
    private long longitude;
    private String registeredTime;

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
