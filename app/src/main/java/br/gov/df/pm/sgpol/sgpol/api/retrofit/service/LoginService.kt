package br.gov.df.pm.sgpol.sgpol.api.retrofit.service

import br.gov.df.pm.sgpol.sgpol.entity.Login
import br.gov.df.pm.sgpol.sgpol.entity.Vehicle
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginService {

    @GET("login")
    fun findCredential(): Call<Login>

    @POST("login")
    fun insertCredential(@Body login: Login): Call<Login>
}