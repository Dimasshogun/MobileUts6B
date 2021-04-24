package id.rdev.Dim.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.rdev.Dim.R
import id.rdev.Dim.activity._main.MainActivity
import id.rdev.Dim.activity.data_barang.DataBarangActivity
import id.rdev.Dim.activity.register.RegisterActivity
import id.rdev.Dim.base.BaseActivity
import id.rdev.Dim.model.User
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Untuk login otomatis
//        val user = User()
//        user.idUser = 0
//        user.username = "guest"
//        user.email = "guest@rizal.com"
//        user.hp = "90123912893323"
//        startActivity<MainActivity>(BaseActivity.TAGS.USER to user)
        initActionButton()
    }

    private fun initActionButton() {
        btLogin.onClick {
            val user = User()
            user.username = etLoginUsername.text.toString()
            user.password = etLoginPassword.text.toString()

            LoginPresenter(this@LoginActivity).login(user)
        }
        goRegister.onClick {
            startActivity<RegisterActivity>()
        }
    }

    override fun onSuccessLogin(user: User?) {
        toast("Berhasil login").show()

        startActivity<DataBarangActivity>(BaseActivity.TAGS.USER to user)
    }

    override fun onErrorLogin(msg: String?) {
        toast(msg ?: "").show()
    }
}
