package com.projects.fairfaxchallenge.data.net;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.projects.fairfaxchallenge.BuildConfig;
import com.projects.fairfaxchallenge.MainApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.projects.fairfaxchallenge.data.net.ApiConstants.DEFAULT_CONNECT_TIMEOUT;
import static com.projects.fairfaxchallenge.data.net.ApiConstants.DEFAULT_READ_TIMEOUT;


/**
 * {@link DataService} implementation for Retrieving Data from Network
 */

public class DataServiceImpl {

    private static final String TAG = DataServiceImpl.class.getSimpleName();

    private DataServiceImpl() {
    }

    /**
     * static method to getinstance and pull Data from Network
     *
     * @return {@link DataService}
     */
    public static DataService getInstance() {
        File cacheDir;
        Cache cache = null;
        try {
            cacheDir = new File(MainApplication.get().getCacheDir(), "http");
            cache = new Cache(cacheDir, ApiConstants.CACHE_SIZE);
        } catch (Exception ex) {
            //Log.e(TAG, "Cannot Create Cache File");
        }
        // Create OkHTTP Client builder
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(getLoggingInterceptor(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(new ResponseCacheInterceptor())
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.FAIRFAXSERVICEURL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(DataService.class);
    }

    /**
     * Interceptor to cache data and maintain it for a minute.
     * <p>
     * If the same network request is sent within a minute,
     * the response is retrieved from cache.
     */
    private static class ResponseCacheInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 60)
                    .build();
        }
    }

    /**
     * Sets HTTP logging levels
     *
     * @return {@link Interceptor}
     */
    @NonNull
    private static Interceptor getLoggingInterceptor(HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }


}
