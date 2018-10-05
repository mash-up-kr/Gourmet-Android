package up.mash.gourmet_mash_up.data.remote.api;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithWishModel;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.UserModel;
import up.mash.gourmet_mash_up.data.remote.model.login.RegisterRes;
import up.mash.gourmet_mash_up.data.remote.model.login.SignInCommand;
import up.mash.gourmet_mash_up.data.remote.model.login.TokenModel;

public interface GourmetRESTClient {

    /**
     * Auth-Controller
     */
    @Headers("Content-Type: application/json")
    @POST("/api/auth/register")
    Observable<RegisterRes> registerUser(@Body SignInCommand UserRegisterBody);

    @FormUrlEncoded
    @Headers("Authorization: Basic Z291cm1ldC1jbGllbnQ6c2VjcmV0")
    @POST("/api/oauth/token")
    Observable<TokenModel> login(@Field("username") String userName,
                                 @Field("password") String password,
                                 @Field("grant_type") String grant_type);

    /**
     * Me-Controller
     */
    @GET("/api/me")
    Flowable<UserModel> getMe(@Header("Authorization") String authorization);

    @Multipart
    @PUT("/api/me")
    Observable<UserModel> setMe(@Header("Authorization") String authorization,
                                @Part MultipartBody.Part profile,
                                @Part("introduce") RequestBody introduce);

    @Multipart
    @PUT("/api/me")
    Observable<UserModel> setMeWithoutImage(@Header("Authorization") String authorization,
                                            @Part("introduce") RequestBody introduce);

    @GET("/api/me/stamps")
    Observable<BaseListModelWithReviewModel> getStampesByMe(@Header("Authorization") String authorization);

    @GET("/api/me/wishlist")
    Observable<BaseListModelWithWishModel> getWishlists(@Header("Authorization") String authorization);
    //TODO Query

    @GET("/api/newsfeed")
    Observable<BaseListModelWithReviewModel> getTotalWishlists(@Header("Authorization") String authorization);

    /**
     * user-Controller
     */
    @GET("/user/{userId}")
    Call<UserModel> getUser(@Path("userId") int userId);

    @POST("/user/{userId}/follow")
    Call<String> setFollowUser(@Path("userId") int userId);

    @DELETE("/user/{userId}/follow")
    Call<String> deleteFollowUser(@Path("userId") int userId);

    @GET("/user/{userId}/stamps")
    Call<BaseListModelWithReviewModel> getFollowUser(@Path("userId") int userId,
                                                     @Query("count") int count,
                                                     @Query("cursor") int cursor);

    /**
     * wish 추가
     */
    @Multipart
    @POST("/api/wish")
    Observable<ReviewModel> addSingleWishList(@Header("Authorization") String authorization,
                                              @Part MultipartBody.Part file,
                                              @Part("restaurant") RequestBody restaurant,
                                              @Part("address") RequestBody address,
                                              @Part("menu") RequestBody menu,
                                              @Part("price") RequestBody price
    );

    /**
     * Stamp 추가
     */
    @Multipart
    @POST("/api/review")
    Observable<ReviewModel> addSingleStamp(@Header("Authorization") String authorization,
                                           @Part MultipartBody.Part file,
                                           @Part("restaurant") RequestBody restaurant,
                                           @Part("address") RequestBody address,
                                           @Part("menu") RequestBody menu,
                                           @Part("comment") RequestBody comment,
                                           @Part("stamp") RequestBody stamp);
}