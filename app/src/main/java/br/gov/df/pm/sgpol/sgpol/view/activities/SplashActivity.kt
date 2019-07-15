package br.gov.df.pm.sgpol.sgpol.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import br.gov.df.pm.sgpol.sgpol.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handle = Handler()
        handle.postDelayed({ goLoginActivity() }, 2000)
    }

    private fun goLoginActivity() {
        val intent =  Intent(this@SplashActivity,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}