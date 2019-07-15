package br.gov.df.pm.sgpol.sgpol.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Policiman(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "nome")
    val name: String,
    @ColumnInfo(name = "placa")
    var cpf: String,
    var rg_policiman : String,
    var cnh_policiman : String,
    var cat_policiman : String,
    var value : String,
    var inclusion : String,
    var tservice : String,
    var matricula : String,
    var siape : String
)