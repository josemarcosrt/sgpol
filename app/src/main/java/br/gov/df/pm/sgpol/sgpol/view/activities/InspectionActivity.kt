package br.gov.df.pm.sgpol.sgpol.view.activities

import android.os.Bundle
import android.os.Handler
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager
import br.gov.df.pm.sgpol.sgpol.R
import br.gov.df.pm.sgpol.sgpol.api.CallbackResponse
import br.gov.df.pm.sgpol.sgpol.api.retrofit.client.VehicleClient
import br.gov.df.pm.sgpol.sgpol.entity.Vehicle
import br.gov.df.pm.sgpol.sgpol.model.Note
import br.gov.df.pm.sgpol.sgpol.view.activities.adapters.InspectionVehicleAdapter
import kotlinx.android.synthetic.main.activity_inspection_vehicle.*
import kotlinx.android.synthetic.main.toolbar_inspection_vehicle.*
//import java.util.ArrayList
import kotlin.collections.ArrayList


class InspectionActivity : SuperActivity() {

    //private var vehiclesList: ArrayList<Vehicle> = ArrayList()
    private val vehiclesList: MutableList<Vehicle> = mutableListOf()

    lateinit var inspectionAdapter: InspectionActivity
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: InspectionVehicleAdapter

    private val notes: MutableList<Note> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspection_vehicle)

        setEventClicks()

        linearLayoutManager = LinearLayoutManager(this)
        rv_inspection_vehicle.layoutManager = linearLayoutManager

        //showProgress()
        VehicleClient().listVehicles(object :  CallbackResponse<List<Vehicle>> {
            override fun success(vehicles: List<Vehicle>) {
                this@InspectionActivity.vehiclesList.addAll(vehicles)
                //configureList()
            }
        })

        val handle = Handler()
        showProgress()
        handle.postDelayed({
            hideProgress()
        }, 3000)
        adapter = InspectionVehicleAdapter(vehiclesList as ArrayList<Vehicle>)
        adapter.notifyDataSetChanged()
        rv_inspection_vehicle.adapter = adapter
    }

    private fun setEventClicks() {
        /*
        imgToolbarRefresh.setOnClickListener {
            imgToolbarRefresh.animate().rotationBy(1440f).duration = 1000
            Toast.makeText(this@InspectionActivity, "Atualizando..", Toast.LENGTH_SHORT).show()
        }*/
        imgBackRightToolbarVistoria.setOnClickListener {
            finish()
            //startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun showProgress() {
        rv_inspection_vehicle.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
         //fab.isEnabled = false
    }

    private fun hideProgress() {
        rv_inspection_vehicle.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
        //fab.isEnabled = true
    }

}