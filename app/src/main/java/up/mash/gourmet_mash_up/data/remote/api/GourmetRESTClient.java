package up.mash.gourmet_mash_up.data.remote.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import up.mash.gourmet_mash_up.data.remote.model.login.LoginReq;
import up.mash.gourmet_mash_up.data.remote.model.login.LoginRes;
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
    Call<RegisterRes> registerUser(@Body LoginReq UserRegisterBody);

    @Headers("Authorization: Basic Z291cm1ldC1jbGllbnQ6c2VjcmV0")
    @POST("/api/oauth/token")
    Call<LoginRes> login(@Field("username") String userName,
                         @Field("password") String password,
                         @Field("grant_type") String grant_type);
}