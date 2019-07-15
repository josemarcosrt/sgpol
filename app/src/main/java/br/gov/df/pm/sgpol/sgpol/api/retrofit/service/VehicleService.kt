package br.gov.df.pm.sgpol.sgpol.api.retrofit.service

import br.gov.df.pm.sgpol.sgpol.entity.Vehicle
import br.gov.df.pm.sgpol.sgpol.model.Note
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface VehicleService {

    @GET("viaturas")
    fun listVehicles(): Call<List<Vehicle>>

    @POST("viatura")
    fun insert(@Body vehicle: Vehicle): Call<Vehicle>

}