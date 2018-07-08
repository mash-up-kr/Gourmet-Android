package up.mash.gourmet_mash_up.data.remote.model;

import java.util.ArrayList;

public class Review {

    private int id;
    private String stamp;
    private Author author;
    private Restaurant restaurant;
    private ArrayList<Menu> menus;

    public int getId() {
        return id;
    }

    public String getStamp() {
        return stamp;
    }

    public Author getAuthor() {
        return author;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}
