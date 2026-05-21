package io.aristiyo.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aristiyo.core.BuildConfig
import io.aristiyo.core.source.remote.ApiService
import okhttp3.CertificatePinner
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideCertificatePinner(): CertificatePinner {
        val hostname = BuildConfig.BASE_URL.toHttpUrl().host
        return CertificatePinner
            .Builder()
            .add(hostname, BuildConfig.CERTIFICATE_PIN)
            .add(hostname, BuildConfig.CERTIFICATE_PIN2)
            .build()
    }

    @Provides
    fun provideOkHttpClient(certificatePinner: CertificatePinner): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    },
                ),
            ).certificatePinner(certificatePinner)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit =
            Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        return retrofit.create(ApiService::class.java)
    }
}
