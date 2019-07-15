package br.gov.df.pm.sgpol.sgpol.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.*

@Entity
data class Vehicle(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "nome")
    val nome: String,
    @ColumnInfo(name = "placa")
    var placa: String,

    var condicao : String,
    var revavam : String,
    var combustivel : String,
    var status : String,
    @ColumnInfo(name = "odometroBoolen")
    var odometroBoolen : Boolean,
    var latariaEpinturaBoolen : Boolean,
    @ColumnInfo(name = "espelhoEvidrosBoolen")
    var espelhosEvidros : Boolean,
    @ColumnInfo(name = "luzesEpainelBoolen")
    var luzesEpainel : Boolean,
    @ColumnInfo(name = "pneusEequipamentosBoolen")
    var radioEson : Boolean,
    @ColumnInfo(name = "radioESonsBoolen")
    var pneusEequipamentos : Boolean,
    //@ColumnInfo(name = "aguaDoradiadorBoolen")
    var aguaDoradiadorBoolen : Boolean
    //@ColumnInfo(name = "oleaMotorBoolen")
    //var oleaMotorBoolen : String
)