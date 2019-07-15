package br.gov.df.pm.sgpol.sgpol.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import br.gov.df.pm.sgpol.sgpol.R
import com.tutorialwing.expandablelistview.CustomExpandableListAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_header_home.*
import kotlinx.android.synthetic.main.toolbar_home.*
import org.jetbrains.anko.doAsync


class HomeActivity : SuperActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpToolbarDrawer(toolbar)
        setEventClicks()

    }

    private fun setEventClicks() {
        imgToolbarRefresh.setOnClickListener {
            doAsync {
                //PatrimonioDatabase.createDatabase(application.applicationContext)
            }
            imgToolbarRefresh.animate().rotationBy(1440f).duration = 1000
            //Toast.makeText(this@HomeActivity, "Atualizando..", Toast.LENGTH_SHORT).show()
        }
    }
    //DrawerLayout
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}


/*
val redmiMobiles = ArrayList<String>()
redmiMobiles.add("Redmi Y2")
redmiMobiles.add("Redmi S2")
redmiMobiles.add("Redmi Note 5 Pro")
redmiMobiles.add("Redmi Note 5")
redmiMobiles.add("Redmi 5 Plus")
redmiMobiles.add("Redmi Y1")
redmiMobiles.add("Redmi 3S Plus")

val micromaxMobiles = ArrayList<String>()
micromaxMobiles.add("Micromax Bharat Go")
micromaxMobiles.add("Micromax Bharat 5 Pro")
micromaxMobiles.add("Micromax Bharat 5")
micromaxMobiles.add("Micromax Canvas 1")
micromaxMobiles.add("Micromax Dual 5")

val appleMobiles = ArrayList<String>()
appleMobiles.add("iPhone 8")
appleMobiles.add("iPhone 8 Plus")
appleMobiles.add("iPhone X")
appleMobiles.add("iPhone 7 Plus")
appleMobiles.add("iPhone 7")
appleMobiles.add("iPhone 6 Plus")

val samsungMobiles = ArrayList<String>()
samsungMobiles.add("Samsung Galaxy S9+")
samsungMobiles.add("Samsung Galaxy Note 7")
samsungMobiles.add("Samsung Galaxy Note 5 Dual")
samsungMobiles.add("Samsung Galaxy S8")
samsungMobiles.add("Samsung Galaxy A8")
samsungMobiles.add("Samsung Galaxy Note 4")

listData["Redmi"] = redmiMobiles
listData["Micromax"] = micromaxMobiles
listData["Apple"] = appleMobiles
listData["Samsung"] = samsungMobiles
*/