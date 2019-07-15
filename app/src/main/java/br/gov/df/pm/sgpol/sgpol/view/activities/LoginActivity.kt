package br.gov.df.pm.sgpol.sgpol.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import br.gov.df.pm.sgpol.sgpol.R

import br.gov.df.pm.sgpol.sgpol.api.CallbackResponse
import br.gov.df.pm.sgpol.sgpol.api.retrofit.client.LoginClient
import br.gov.df.pm.sgpol.sgpol.entity.Login
import kotlinx.android.synthetic.main.activity_login.*

import androidx.lifecycle.ViewModelProviders
import viewmodel.LoginViewModel
import viewmodel.LoginViewModelFactory


class LoginActivity : SuperActivity() {


    private val login1: Login? = null
    private val login: MutableList<Login> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*
        val database = PatrimonioDatabase.getInstance(applicationContext)
        val inventarioRepository = InventarioRepository(database.inventarioDao())
        val viewModel = ViewModelProviders.of(this, LoginViewModelFactory(application, inventarioRepository))
            .get(LoginViewModel::class.java)
        */


        val viewModel =  ViewModelProviders.of(this,LoginViewModelFactory(application)).get(LoginViewModel::class.java)

        /*
        //showProgress()
        VehicleClient().listVehicles(object :  CallbackResponse<List<Vehicle>> {
            override fun success(vehicles: List<Vehicle>) {
                this@InspectionActivity.vehiclesList.addAll(vehicles)
                //configureList()
            }
        })
        */

        btn_login.setOnClickListener {

            viewModel.login( input_login.text.toString(), input_senha.text.toString())
            //val login = Login("jose","123")

            /*
            val login = input_login.text.toString()
            val senha = input_senha.toString()
            var loginCredentions = Login(login,senha)
            LoginClient().findCredentiols(loginCredentions, object : CallbackResponse<Login> {
                override fun success(login: Login) {
                    this@LoginActivity.login.add(login)
                }
            })*/

            //LoginClient().findCredentiols()
        }

        // observa o resultado de sucesso do login
        viewModel.sucesso.observe(this,  Observer { login ->
            val intent =  Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        })

        // observa os cenarios de erro do login
        viewModel.erros.observe(this, Observer { mensagem ->
            AlertDialog.Builder(this@LoginActivity).apply {
                setTitle(mensagem.titulo)
                setMessage(mensagem.conteudo)
                setPositiveButton(android.R.string.ok) { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                create().show()
            }
        })

    }


}