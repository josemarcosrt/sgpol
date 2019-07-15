package br.gov.df.pm.sgpol.sgpol.api.retrofit.client

import android.util.Log
import br.gov.df.pm.sgpol.sgpol.api.CallbackResponse
import br.gov.df.pm.sgpol.sgpol.api.RetrofitInitializer
import br.gov.df.pm.sgpol.sgpol.entity.Vehicle
import br.gov.df.pm.sgpol.sgpol.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehicleClient {



    fun listVehicles(callbackResponse: CallbackResponse<List<Vehicle>>) {
        val call = RetrofitInitializer().vehicleService().listVehicles()
        call.enqueue(object : Callback<List<Vehicle>?> {
            override fun onResponse(call: Call<List<Vehicle>?>?, response: Response<List<Vehicle>?>?) {
                response?.body()?.let {
                    val vehicles: List<Vehicle> = it
                    callbackResponse.success(vehicles)
                }
            }

            override fun onFailure(call: Call<List<Vehicle>?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun insert(vehicle: Vehicle, callbackResponse: CallbackResponse<Vehicle>) {
        val call = RetrofitInitializer().vehicleService().insert(vehicle);
        call.enqueue(object : Callback<Vehicle?> {
            override fun onResponse(call: Call<Vehicle?>?, response: Response<Vehicle?>?) {
                response?.body()?.let {
                    val vehicle: Vehicle = it
                    callbackResponse.success(vehicle)
                }
            }

            override fun onFailure(call: Call<Vehicle?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }
}