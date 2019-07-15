package br.gov.df.pm.sgpol.sgpol.api.retrofit.client

import android.util.Log
import br.gov.df.pm.sgpol.sgpol.api.CallbackResponse
import br.gov.df.pm.sgpol.sgpol.api.RetrofitInitializer
import br.gov.df.pm.sgpol.sgpol.entity.Login
import br.gov.df.pm.sgpol.sgpol.entity.Vehicle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginClient {

    fun findCredentiols(callbackResponse: CallbackResponse<Login>) {
        val call = RetrofitInitializer().LoginService().findCredential();
        call.enqueue(object : Callback<Login?> {
            override fun onResponse(call: Call<Login?>?, response: Response<Login?>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                response?.body()?.let {
                    val login: Login = it
                    callbackResponse.success(login)
                }
            }

            override fun onFailure(call: Call<Login?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }



    fun findCredentiols(login: Login, callbackResponse: CallbackResponse<Login>) {
        val call =  RetrofitInitializer().LoginService().insertCredential(login)
        call.enqueue(object :Callback<Login?>{
            override fun onResponse(call: Call<Login?>?, response: Response<Login?>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                response?.body()?.let {
                    val login: Login = it
                    callbackResponse.success(login)
                }
            }

            override fun onFailure(call: Call<Login?>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.e("onFailure error", t?.message)
            }

        })
    }

    fun insert(login: Login, callbackResponse: CallbackResponse<Login>) {
        val call = RetrofitInitializer().LoginService().insertCredential(login)
        call.enqueue(object : Callback<Login?> {
            override fun onResponse(call: Call<Login?>?, response: Response<Login?>?) {
                response?.body()?.let {
                    val login: Login = it
                    callbackResponse.success(login)
                }
            }

            override fun onFailure(call: Call<Login?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

}