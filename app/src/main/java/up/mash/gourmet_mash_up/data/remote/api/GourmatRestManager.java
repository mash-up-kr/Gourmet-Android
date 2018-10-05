package up.mash.gourmet_mash_up.data.remote.api;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import up.mash.gourmet_mash_up.data.remote.BaseNetworkRequestModule;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithWishModel;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.UserModel;
import up.mash.gourmet_mash_up.data.remote.model.login.RegisterRes;
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

    public static Observable<RegisterRes> setRegister(SignInCommand body) {
        return mGourmetRESTClient
                .registerUser(body)
                .subscribeOn(Schedulers.newThread());
    }

    public static Flowable<UserModel> getMe(String authToken) {
        return mGourmetRESTClient
                .getMe("Bearer " + authToken)
                .subscribeOn(Schedulers.newThread());
    }

    public static Observable<UserModel> setMe(String authToken,
                                              MultipartBody.Part profileFile,
                                              RequestBody introduce) {
        return mGourmetRESTClient
                .setMe("Bearer " + authToken, profileFile, introduce)
                .subscribeOn(Schedulers.newThread());
    }

    public static Observable<UserModel> setMeWithoutImage(String authToken,
                                                          RequestBody introduce) {
        return mGourmetRESTClient
                .setMeWithoutImage("Bearer " + authToken, introduce)
                .subscribeOn(Schedulers.newThread());
    }

    public static Flowable<BaseListModelWithReviewModel> getStampListOnMe(String authToken, int count, int size) {
        return mGourmetRESTClient
                .getStampesByMe("Bearer " + authToken, count, size)
                .subscribeOn(Schedulers.newThread());
    }

    public static Flowable<BaseListModelWithWishModel> getWishListOnMe(String authToken, int count, int size) {
        return mGourmetRESTClient
                .getWishlists("Bearer " + authToken, count, size)
                .subscribeOn(Schedulers.newThread());
    }

    public static Observable<List<ReviewModel>> getTotalWishlists(String authToken) {
        return mGourmetRESTClient
                .getTotalWishlists("Bearer " + authToken)
                .map(response -> response.getData())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
