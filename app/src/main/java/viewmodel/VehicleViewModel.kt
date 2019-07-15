package viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class VehicleViewModel (
    private val app: Application
    //private val inventarioRepository: InventarioRepository,
    //private val tipoInventarioRepository: TipoInventarioRepository
) : AndroidViewModel(app) {

    /*
    fun recuperarInventarios() = inventarioRepository.findAll()

    fun recuperarTiposInventarios() = tipoInventarioRepository.findAll()

    fun deletarInventario(inventario: Inventario) = inventarioRepository.delete(inventario)

    fun reabrirInventario(inventario: Inventario) {
        inventario.finalizado = false
        inventarioRepository.update(inventario)
    }

    fun concluirInventario(inventario: Inventario) {
        inventario.finalizado = true
        inventarioRepository.update(inventario)
    }*/

}