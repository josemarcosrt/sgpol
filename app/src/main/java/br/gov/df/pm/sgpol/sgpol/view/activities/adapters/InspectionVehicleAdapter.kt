package br.gov.df.pm.sgpol.sgpol.view.activities.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.gov.df.pm.sgpol.sgpol.entity.Vehicle
import org.jetbrains.anko.selector
import viewmodel.VehicleViewModel
import  br.gov.df.pm.sgpol.sgpol.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_inspection_vehicle.view.*


import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.gov.df.pm.sgpol.sgpol.R.color.*
import br.gov.df.pm.sgpol.sgpol.view.activities.InspectionActivity
import br.gov.df.pm.sgpol.sgpol.view.activities.InspectionVehicleDetail

class InspectionVehicleAdapter(private val vehicles: ArrayList<Vehicle>) : RecyclerView.Adapter<InspectionVehicleAdapter.VehicleHolder>() {
    override fun getItemCount() = vehicles.size

    override fun onBindViewHolder(holder: InspectionVehicleAdapter.VehicleHolder, position: Int) {
        val itemPhoto = vehicles[position]
        holder.bindPhoto(itemPhoto)  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspectionVehicleAdapter.VehicleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inspection_vehicle, parent, false)

        return VehicleHolder(view)
    }

    //1
    class VehicleHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var vehicle: Vehicle? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            val context = itemView.context
            val intent = Intent(context,  InspectionVehicleDetail::class.java)
            //intent = Intent(context, InspectionVehicleDetail::class.java)
            intent.putExtra("nome", vehicle?.nome) //.putExtra(VEHICLE_KEY, vehicle)
            intent.putExtra("placa", vehicle?.placa)
            intent.putExtra("odometro", vehicle?.odometroBoolen)
            intent.putExtra("revavam", vehicle?.revavam)
            intent.putExtra("combustivel", vehicle?.combustivel)
            intent.putExtra("status", vehicle?.status)
            //intent.putExtra("latariaEpinturaBoolen", vehicle?.latariaEpintura)
            intent.putExtra("latariaEpinturaBoolen",vehicle?.latariaEpinturaBoolen.toString())
            intent.putExtra("espelhosEvidros", vehicle?.espelhosEvidros)
            intent.putExtra("luzesEpainel", vehicle?.luzesEpainel)
            intent.putExtra("radioEson", vehicle?.radioEson)
            intent.putExtra("pneusEequipamentos", vehicle?.pneusEequipamentos)
            intent.putExtra("aguadoRadiador", vehicle?.aguaDoradiadorBoolen.toString())
            context.startActivity(intent)
        }

        @SuppressLint("ResourceAsColor")
        fun bindPhoto(vehicle: Vehicle) {
            this.vehicle = vehicle
            //Picasso.with(view.context).load(photo.url).into(view.itemImage)
            view.name_car.text  = vehicle.nome
            view.name_placa.text = vehicle.placa

            //view.opcoes_status.background = ve
            //view.opcoes_status.text

            when (vehicle.status.toString()) {
                "Vistoriado" -> {
                    view.opcoes_status?.setBackgroundColor(view.opcoes_status.resources.getColor(R.color.colorBlue))
                    view.opcoes_status.text = vehicle.status.toString()

                }
                "Disponivél" -> {
                    view.opcoes_status.text = vehicle.status.toString()
                    view.opcoes_status.setBackgroundColor(view.opcoes_status.resources.getColor(R.color.colorGrey))
                }
                "Em uso" -> {
                    view.opcoes_status.text = vehicle.status.toString()
                    view.opcoes_status.setBackgroundColor(view.opcoes_status.resources.getColor(R.color.colorRed))
                }
                //else -> monthString = "Invalid month"
            }

            // view.opcoes_status.text = vehicle.status.toString()
            //println(monthString)

            //if (perfil.equals("A")) novoPerfil = "Administrador" else novoPerfil = "Padrão"

        }

        companion object {
            //5
            private val VEHICLE_KEY = "VEHICLE_KEY"
        }
    }
}


/*
class  InspectionVehicleAdapter  (var vehicles: List<Vehicle> = emptyList(), var viewModel: VehicleViewModel) :
    RecyclerView.Adapter<InspectionVehicleAdapter.ViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inspection_vehicle, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicle = vehicles.get(position)
        holder.name.text = vehicle.name
        holder.placa.text = vehicle.placa
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.name_car
        var placa = itemView.placa
    }

}
        */