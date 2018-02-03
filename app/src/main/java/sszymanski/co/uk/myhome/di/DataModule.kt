package sszymanski.co.uk.myhome.di

import android.app.Application
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sszymanski.co.uk.myhome.data.UserService
import sszymanski.co.uk.myhome.utils.StaticValues
import javax.inject.Singleton

/**
 * Created by rex on 03/02/2018.
 */
@Module
class DataModule {


    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
    @Provides
    @Singleton
    fun provideGson():Gson = Gson()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,gson:Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(StaticValues.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// custom client
                .build();
    }

}