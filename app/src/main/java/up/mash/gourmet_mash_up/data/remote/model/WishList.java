package up.mash.gourmet_mash_up.data.remote.model;

public class WishList {

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

    public class Data {

        private int id;
        private String name;
        private int price;
        private String registeredTime;
        private String[] taste;
        private String wishedAt;

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

        public String[] getTaste() {
            return taste;
        }

        public String getWishedAt() {
            return wishedAt;
        }
    }
}
