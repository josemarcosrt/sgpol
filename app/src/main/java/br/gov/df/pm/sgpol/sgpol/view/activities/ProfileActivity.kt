package br.gov.df.pm.sgpol.sgpol.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import br.gov.df.pm.sgpol.sgpol.R
import com.tutorialwing.expandablelistview.CustomExpandableListAdapter
import kotlinx.android.synthetic.main.toolbar_home.*
import kotlinx.android.synthetic.main.toolbar_inspection_vehicle.*
import kotlinx.android.synthetic.main.toolbar_profile.*
import org.jetbrains.anko.doAsync

class ProfileActivity : SuperActivity() {

    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val redmiMobiles = ArrayList<String>()
            redmiMobiles.add("")

            val micromaxMobiles = ArrayList<String>()
            micromaxMobiles.add("")

            val appleMobiles = ArrayList<String>()
            appleMobiles.add("")

            listData["Dados Pessoais: "] = redmiMobiles
            listData["Formação"] = micromaxMobiles
            listData["Depentes"] = appleMobiles

            return listData
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //setUpToolbarDrawer(toolbar)
        setEventClicks()


        expandableListView = findViewById(R.id.expandableListView)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)

            expandableListView!!.setOnGroupExpandListener {
                    //groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show()
            }

            expandableListView!!.setOnGroupCollapseListener {
                    //groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show()
            }

            expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                //Toast.makeText(applicationContext, "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition), Toast.LENGTH_SHORT).show()
                false
            }
        }



        //https://tutorialwing.com/android-expandablelistview-using-kotlin-example/
        /*
        expandableListView!!.setOnGroupExpandListener {
                groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show()
        }

        expandableListView!!.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show()
        }

        expandableListView!!.setOnChildClickListener {
                parent, v, groupPosition, childPosition, id ->
            //Toast.makeText(applicationContext, "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition), Toast.LENGTH_SHORT).show()
            false
        }
        */


    }
    //fun onGroupCollapsed(groupPosition: Int) {
    //    Toast.makeText( applicationContext , (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show()
    //}


    private fun setEventClicks() {
        /*
        imgToolbarRefresh.setOnClickListener {
            doAsync {
                //PatrimonioDatabase.createDatabase(application.applicationContext)
            }
            imgToolbarRefresh.animate().rotationBy(1440f).duration = 1000
            Toast.makeText(this@ProfileActivity, "Atualizando..", Toast.LENGTH_SHORT).show()
        }*/

        imgBackRightToolbarProfile.setOnClickListener {
            finish()
            //startActivity(Intent(this, HomeActivity::class.java))
        }


    }
    //DrawerLayout
    /*
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }*/

}