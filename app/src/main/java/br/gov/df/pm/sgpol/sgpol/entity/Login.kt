package br.gov.df.pm.sgpol.sgpol.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
@Entity
data class Login(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "login")
    val login: Char,
    @ColumnInfo(name = "password")
    var password: String
)
*/
@Entity
data class Login(@PrimaryKey val email: String?, val password: String?)