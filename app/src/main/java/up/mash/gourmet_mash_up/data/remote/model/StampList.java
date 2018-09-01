package up.mash.gourmet_mash_up.data.remote.model;

public class StampList {

    private int count;
    private int totalCount;
    private int cursor;
    private Data data;

    public int getCount() {
        return count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCursor() {
        return cursor;
    }

    public Data getData() {
        return data;
    }

    private class Data {

        private int id;
        private String stamp;
        private Author author;
        private Restaurant restaurant;
        private Menu menu;


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

        public Menu getMenu() {
            return menu;
        }
    }
}
