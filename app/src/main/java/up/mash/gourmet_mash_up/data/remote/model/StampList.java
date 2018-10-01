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
        private UserModel mUserModel;
        private RestaurantModel mRestaurantModel;
        private MenuModel mMenuModel;


        public int getId() {
            return id;
        }

        public String getStamp() {
            return stamp;
        }

        public UserModel getUserModel() {
            return mUserModel;
        }

        public RestaurantModel getRestaurantModel() {
            return mRestaurantModel;
        }

        public MenuModel getMenuModel() {
            return mMenuModel;
        }
    }
}
