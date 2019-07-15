package br.gov.df.pm.sgpol.sgpol.api

import br.gov.df.pm.sgpol.sgpol.api.retrofit.service.LoginService
import br.gov.df.pm.sgpol.sgpol.api.retrofit.service.VehicleService
import retrofit2.Retrofit

import retrofit2.converter.moshi.MoshiConverterFactory

//http://192.168.0.23:8080

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        //https://app-pmdf.herokuapp.com/api/viaturas
        //.baseUrl("http://192.168.0.105:8080/api/")
        //.baseUrl("https://reqres.in/")
        .baseUrl("https://app-pmdf.herokuapp.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        //.addConverterFactory(GsonConverterFactory.create())
        .build()

    fun LoginService(): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    fun vehicleService(): VehicleService {
        return retrofit.create(VehicleService::class.java)
    }
}