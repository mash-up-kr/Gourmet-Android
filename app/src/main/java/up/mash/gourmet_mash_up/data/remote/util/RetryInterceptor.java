package up.mash.gourmet_mash_up.data.remote.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Retry 2번 시도
 */
public class RetryInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        int tryCount = 0;
        int maxLimit = 2;
        while (!response.isSuccessful() && tryCount < maxLimit) {
            Log.d("interceptor", "Request failed - " + tryCount);
            tryCount++;
            response = chain.proceed(request);
            if (maxLimit == 2) {
//                    Context application = AZWeatherContext.getContext();
//                    Log.e("interceptor", "문제발생");
            }
        }
        return response;
    }
}
