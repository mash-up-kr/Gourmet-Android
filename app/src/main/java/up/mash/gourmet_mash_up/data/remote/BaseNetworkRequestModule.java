package up.mash.gourmet_mash_up.data.remote;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import up.mash.gourmet_mash_up.BuildConfig;
import up.mash.gourmet_mash_up.data.remote.api.ApiService;
import up.mash.gourmet_mash_up.data.remote.util.ApiKeyInterceptor;

public class BaseNetworkRequestModule {

    private static final String BASE_URL = "";
//    private static

    private static ApiService apiService;

    public static ApiService getService() {
        if(apiService == null){
            apiService = getApiService();
        }
        return apiService;
    }

    private static ApiService getApiService(){
        final OkHttpClient okHttpClient = getOkHttpClient();
        final Retrofit retrofit = getRetrofit(okHttpClient);
        return retrofit.create(ApiService.class);
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
        }

        builder.addInterceptor(new ApiKeyInterceptor());

        return builder.build();
    }
}
