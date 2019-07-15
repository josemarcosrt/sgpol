package br.gov.df.pm.sgpol.sgpol.view.activities


import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_home.*

import com.google.android.material.navigation.NavigationView
import br.gov.df.pm.sgpol.sgpol.R
import br.gov.df.pm.sgpol.sgpol.utils.TextJustification
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.nav_header_home.*
import kotlinx.android.synthetic.main.toolbar_home.*
import kotlinx.android.synthetic.main.toolbar_default.*

open class SuperActivity : AppCompatActivity (),  NavigationView.OnNavigationItemSelectedListener {

    fun setUpToolbarDrawer(toolbar: androidx.appcompat.widget.Toolbar) {

        navView.setNavigationItemSelectedListener(this)
        setSupportActionBar(toolbar)
        val toggle =  ActionBarDrawerToggle(
            this,
               drawerLayout,
               toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )

        imgToolbarMenu.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.END)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }


            buttonProfile.setOnClickListener{
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            buttonSair.setOnClickListener{
                //realizar logout
                finish()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

        TextJustification.justify(firstParagraph)
        TextJustification.justify(secondParagraph)

        drawerLayout.addDrawerListener(toggle)
    }

    protected fun setUpToolbarDefault(text: String) {
        toolbar_title.text = (text)

        imgBack.setOnClickListener { finish() }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {


            R.id.buttonProfile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            R.id.buttonSair -> {
                //realizar logout
                finish()
                //startActivity(Intent(this, LoginActivity::class.java))
            }

            R.id.menu_vistoria_viatura -> {
                startActivity(Intent(this, InspectionActivity::class.java))
            }
            R.id.menu_serve_volunter -> {
                //startActivity(Intent(this, AssociarTagActivity::class.java))
            }

        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
