package br.gov.df.pm.sgpol.sgpol

import android.app.Application
import java.util.*

open class SuperApplication : Application(){
    open val locale: Locale
        get() = Locale("pt", "BR")
}
