package br.gov.df.pm.sgpol.sgpol.manager

import br.gov.df.pm.sgpol.sgpol.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

object ApiManager {
    private const val SERVER: String = "https://api.github.com/"


    private lateinit var mGithubService:  ApiService

    init {
        val retrofit = initRetrofit()
        initServices(retrofit)
    }

    private fun initRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }

        return Retrofit.Builder().baseUrl(SERVER)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(createMoshiConverter())
            .client(client.build())
            .build()
    }

    private fun createMoshiConverter(): MoshiConverterFactory = MoshiConverterFactory.create()

    private fun initServices(retrofit: Retrofit) {
        mGithubService = retrofit.create(ApiService::class.java)
    }

    fun loadOrganizationRepos(organizationName: String, reposType: String) =
        mGithubService.getOrganizationRepos(organizationName, reposType)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())!!


    fun loadRepository(owner: String, name: String) =
        mGithubService.getRepository(owner, name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())!!

}