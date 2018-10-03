package up.mash.gourmet_mash_up.data.remote.api;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.BaseListModelWithWishModel;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;
import up.mash.gourmet_mash_up.data.remote.model.ReviewPostCommand;
import up.mash.gourmet_mash_up.data.remote.model.UserModel;
import up.mash.gourmet_mash_up.data.remote.model.WishModel;
import up.mash.gourmet_mash_up.data.remote.model.login.SignInCommand;
import up.mash.gourmet_mash_up.data.remote.model.login.TokenModel;
import up.mash.gourmet_mash_up.data.remote.model.login.RegisterRes;

public interface GourmetRESTClient {


    /**
     * User
     */
//    @GET("/user")
//    Call<User> getUser(@Query("userid") String userid);

//    @POST("/user/{userid}/follow")
//    Call<User> setFollowUser();


    /**
     * Log in
     */
    @Headers("Content-Type: application/json")
    @POST("/api/auth/register")
    Flowable<RegisterRes> registerUser(@Body SignInCommand UserRegisterBody);


    @FormUrlEncoded
    @Headers("Authorization: Basic Z291cm1ldC1jbGllbnQ6c2VjcmV0")
    @POST("/api/oauth/token")
    Flowable<TokenModel> login(@Field("username") String userName,
                           @Field("password") String password,
                           @Field("grant_type") String grant_type);

    @GET("/api/me")
    Flowable<UserModel> getMe(@Header("Authorization") String authorization);

    @PUT("/api/me")
    Call<UserModel> setMe(@Header("Authorization") String authorization);

    @GET("/api/me/stamps?page={page}&size={size}")
    Flowable<BaseListModelWithReviewModel> getStampes(@Header("Authorization") String authorization,
                                                      @Path("page") int count,
                                                      @Path("size") int size);

    @GET("/api/me/wishlist?page={page}&size={size}")
    Flowable<BaseListModelWithWishModel> getWishlists(@Header("Authorization") String authorization,
                                                      @Path("page") int count,
                                                      @Path("size") int size);

    @Headers("Content-Type: application/json")
    @POST("/review")
    Call<ReviewModel> reviewPostCommand(@Body ReviewPostCommand command);

    @GET("/review/{reviewId}")
    Call<ReviewModel> getReview(@Path("reviewId") int id);

    @POST("/review/{reviewId}/wish")
    Call<WishModel> setWishList(@Path("reviewId") int id);

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
}
