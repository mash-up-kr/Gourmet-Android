package up.mash.gourmet_mash_up.data.remote;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import up.mash.gourmet_mash_up.BuildConfig;
import up.mash.gourmet_mash_up.data.remote.api.GourmetRESTClient;
import up.mash.gourmet_mash_up.data.remote.model.login.LoginReq;
import up.mash.gourmet_mash_up.data.remote.model.login.LoginRes;
import up.mash.gourmet_mash_up.data.remote.model.login.RegisterRes;
import up.mash.gourmet_mash_up.data.remote.util.ApiKeyInterceptor;
import up.mash.gourmet_mash_up.data.remote.util.RequestResponseTimeInterceptor;
import up.mash.gourmet_mash_up.data.remote.util.RetryInterceptor;


public class BaseNetworkRequestModule {

    private static final String BASE_URL = "http://175.158.15.189:8080";

    private static GourmetRESTClient sGourmetRESTClient;

    public static GourmetRESTClient getService() {
        if (sGourmetRESTClient == null) {
            sGourmetRESTClient = getGourmetRESTClient();
        }
        return sGourmetRESTClient;
    }

    private static GourmetRESTClient getGourmetRESTClient() {
        final OkHttpClient okHttpClient = getOkHttpClient();
        final Retrofit retrofit = getRetrofit(okHttpClient);
        return retrofit.create(GourmetRESTClient.class);
    }

    private static Retrofit getRetrofit(OkHttpClient okHttpClient) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient);
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(
                GsonConverterFactory.create(new GsonBuilder().setPrettyPrinting().create()));

        return builder.build();
    }

    private static OkHttpClient getOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
            builder.addInterceptor(new RequestResponseTimeInterceptor());
        }
        builder.addInterceptor(new ApiKeyInterceptor());
        builder.addInterceptor(new RetryInterceptor());
        return builder.build();
    }

    public static void requestRegisterUser(String id, String password, Callback<RegisterRes> callback) {
        LoginReq req = new LoginReq(id, password);
        getService().registerUser(req).enqueue(callback);
    }

    public static void requestLogIn(String id, String password, Callback<LoginRes> callback) {
        getService().login(id, password, "password").enqueue(callback);
    }
}
