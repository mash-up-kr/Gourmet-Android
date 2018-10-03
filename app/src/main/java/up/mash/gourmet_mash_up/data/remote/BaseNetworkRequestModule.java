package up.mash.gourmet_mash_up.data.remote;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import up.mash.gourmet_mash_up.BuildConfig;
import up.mash.gourmet_mash_up.data.remote.api.GourmetRESTClient;
import up.mash.gourmet_mash_up.data.remote.util.ApiKeyInterceptor;
import up.mash.gourmet_mash_up.data.remote.util.RequestResponseTimeInterceptor;
import up.mash.gourmet_mash_up.data.remote.util.RetryInterceptor;


public class BaseNetworkRequestModule {

    private static final String BASE_URL = "http://220.230.121.118:8080";

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
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
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
}
