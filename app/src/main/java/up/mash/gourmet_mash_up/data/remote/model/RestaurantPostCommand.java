package up.mash.gourmet_mash_up.data.remote.model;

public class RestaurantPostCommand {

    private String address;
    private double latitude;
    private double longitude;
    private String name;

    public RestaurantPostCommand(String address, double latitude, double longitude, String name) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
