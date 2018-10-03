package up.mash.gourmet_mash_up.data.remote.api;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import up.mash.gourmet_mash_up.data.remote.BaseNetworkRequestModule;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithWishModel;
import up.mash.gourmet_mash_up.data.remote.model.UserModel;
import up.mash.gourmet_mash_up.data.remote.model.login.SignInCommand;
import up.mash.gourmet_mash_up.data.remote.model.login.TokenModel;

public class GourmatRestManager {

    private static final GourmetRESTClient mGourmetRESTClient = BaseNetworkRequestModule.getService();

    public static Flowable<TokenModel> logInByUser(String id, String pw) {
        return mGourmetRESTClient
                .login(id, pw, "password")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Flowable setRegister(SignInCommand body) {
        return mGourmetRESTClient
                .registerUser(body)
                .subscribeOn(Schedulers.newThread());
    }

    public static Flowable<UserModel> getMe(String authToken) {
        return mGourmetRESTClient
                .getMe("Bearer " + authToken)
                .subscribeOn(Schedulers.newThread());
    }

    public static Flowable<BaseListModelWithReviewModel> getStampListOnMe(String authToken, int count, int size) {
        return mGourmetRESTClient
                .getStampes("Bearer " + authToken, count, size)
                .subscribeOn(Schedulers.newThread());
    }

    public static Flowable<BaseListModelWithWishModel> getWishListOnMe(String authToken, int count, int size) {
        return mGourmetRESTClient
                .getWishlists("Bearer " + authToken, count, size)
                .subscribeOn(Schedulers.newThread());
    }
}
