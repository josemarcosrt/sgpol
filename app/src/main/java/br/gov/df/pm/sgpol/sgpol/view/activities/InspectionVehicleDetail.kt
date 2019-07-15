package br.gov.df.pm.sgpol.sgpol.view.activities

import android.os.Bundle
import br.gov.df.pm.sgpol.sgpol.R
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inspection_vehicle_detail.*
import kotlinx.android.synthetic.main.toolbar_inspection_vehicle_detail.*
import android.widget.Switch
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.setTag
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener






class InspectionVehicleDetail: SuperActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspection_vehicle_detail)
        setEventClicks()


        //Pega a intent de outra activity
        val it = intent
        //Recuperei a string da outra activity
        val nome = it.getStringExtra("nome")
        val placa = it.getStringExtra("placa")
        //val odometro = it.getBooleanExtra("odometro")

        val revavam = it.getStringExtra("revavam")
        val combustivel = it.getStringExtra("combustivel")

        //val latariaEpintura  = it.getStringExtra("latariaEpinturaBoolen")
        //val latariaEpintura = it.getBooleanExtra("latariaEpinturaBoolen", false)
        val latariaEpintura = it.getStringExtra("latariaEpinturaBoolen")



        val oleaMotorBoolen = it.getBooleanExtra("oleaMotorBoolen", true)
        val radioESonsBoolen = it.getBooleanExtra("radioESonsBoolen", true)

        val  aguadoRadiador = it.getStringExtra("aguadoRadiador")


        //Toast.makeText(applicationContext, "nome -> " + nome, Toast.LENGTH_SHORT).show()
        //Toast.makeText(applicationContext, "latariaEpintura -> " + latariaEpintura, Toast.LENGTH_SHORT).show()
        //Toast.makeText(applicationContext, "aguadoRadiador -> " + aguadoRadiador, Toast.LENGTH_SHORT).show()

        //val latariaEpintura = getIntent().getBooleanExtra("latariaEpintura", true);
        // initiate a Switch
        val switchLatariaEpintura = findViewById(R.id.latariaEpintura) as Switch
        switchLatariaEpintura.setChecked(latariaEpintura.toBoolean());
        val switchaguaRadiador = findViewById(R.id.latariaEpintura) as Switch
        switchaguaRadiador.setChecked(aguadoRadiador.toBoolean());


        /*
        val espelhosEvidros = getIntent().getBooleanExtra("espelhosEvidros", false);
        val luzesEpainel = getIntent().getBooleanExtra("luzesEpainel", false);
        val radioEson = getIntent().getBooleanExtra("radioEson", false);
        val pneusEequipamentos = getIntent().getBooleanExtra("pneusEequipamentos",false);
        val aguadoRadiador = getIntent().getBooleanExtra("aguadoRadiador", false);

        val switchEspelhosEvidros = findViewById(R.id.espelhoEvidros) as Switch
        switchEspelhosEvidros.setChecked(espelhosEvidros);

        val switchLuzesEpainel = findViewById(R.id.luzesEpanel) as Switch
        switchLuzesEpainel.setChecked(espelhosEvidros);

        val switchRadioEson = findViewById(R.id.radioEsom) as Switch
        switchRadioEson.setChecked(radioEson);

        val switchPneusEequipamentos = findViewById(R.id.radioEsom) as Switch
        switchPneusEequipamentos.setChecked(pneusEequipamentos);

        val switchAguadoRadiador = findViewById(R.id.aguaRadiador) as Switch
        switchAguadoRadiador.setChecked(aguadoRadiador);

        */



    }

    private fun setEventClicks() {
                /*
                    imgToolbarRefresh.setOnClickListener {
                        imgToolbarRefresh.animate().rotationBy(1440f).duration = 1000
                        Toast.makeText(this@InspectionActivity, "Atualizando..", Toast.LENGTH_SHORT).show()
                    }*/
            imgBackRightToolbarVistoriaDetail.setOnClickListener {
                finish()
            }

    }

}


