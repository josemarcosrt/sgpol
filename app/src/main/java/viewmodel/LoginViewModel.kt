package viewmodel

import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.AndroidViewModel
import br.gov.df.pm.sgpol.sgpol.api.CallbackResponse
import br.gov.df.pm.sgpol.sgpol.api.retrofit.client.LoginClient
import br.gov.df.pm.sgpol.sgpol.entity.Login
import br.gov.df.pm.sgpol.sgpol.entity.Mensage
import br.gov.df.pm.sgpol.sgpol.view.activities.SingleLiveEvent

class LoginViewModel(private val app: Application) : AndroidViewModel(app) {

    val erros = SingleLiveEvent< Mensage>()

    val sucesso = SingleLiveEvent<Login>()

    @VisibleForTesting
    fun isFormValido(usuario: String?, senha: String?) = (!usuario.isNullOrEmpty() || usuario !=null) && !senha.isNullOrEmpty()

    fun login(login: String?, senha: String?) {
        if (isFormValido(login, senha)) {
            sucesso.value = Login(login!!, senha!!)
            //sucesso.value = Login(usuario!!, senha!!)
            var loginCredentions = Login(login, senha)
            LoginClient().insert(loginCredentions, object : CallbackResponse<Login> {
                override fun success(login: Login) {
                    sucesso.value = Login(login.toString(), senha)
                }
            })
        } else {

            erros.value = Mensage("Atenção", "Login ou senha com erros")
                //title = app.getString(R.string.atencao),
                //conteudo = app.getString(R.string.validacao_login)
        }


    }

}