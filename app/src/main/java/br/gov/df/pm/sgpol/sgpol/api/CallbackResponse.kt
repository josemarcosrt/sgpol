package br.gov.df.pm.sgpol.sgpol.api

interface CallbackResponse<T> {
    fun success(response: T)
}