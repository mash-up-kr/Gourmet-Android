package up.mash.gourmet_mash_up.data.remote.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import up.mash.gourmet_mash_up.data.remote.model.User;
import up.mash.gourmet_mash_up.data.remote.model.login.LoginRes;

public interface ApiService {


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

    @POST("/auth/register")
    Call<LoginRes> registerUser(@Field("username") String userName,
                               @Field("password") String password);
}
