package kr.co.sy.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.co.sy.myapplication.model.entity.AuthEntity
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.databinding.ActivityLoginBinding
import kr.co.sy.myapplication.network.NetworkHelper
import kr.co.sy.myapplication.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    var network: NetworkHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        init()
    }

    fun init(){

        network = NetworkHelper()
        setListener()

    }

    fun setListener(){

        binding.loginButton.setOnClickListener(this)
        binding.signupButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.loginButton.id -> {
                val id = binding.editId.text.toString()
                val password = binding.editPassword.text.toString()

                network?.let {
                    it.server.loginAccount(id, password).enqueue(object : Callback<AuthEntity> {
                        override fun onFailure(call: Call<AuthEntity>?, t: Throwable?) { //아예 네트워킹의 익셉션
                            Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
                        }
                        override fun onResponse(call: Call<AuthEntity>?, response: Response<AuthEntity>?) {
                            if (response != null) {
                                if (response.isSuccessful) { //JS : 웹 리스폰이 200 일때
                                    val result: AuthEntity? = response.body()
                                    ContextUtil().setUserToken(applicationContext, result?.data?.token)

                                    val nextIntent = Intent(applicationContext, PagerActivity::class.java)
                                    startActivity(nextIntent)
                                } else { // 웹 리스폰이 200이 아닐때 / fail
                                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    })
                }
            }
            binding.signupButton.id-> {
                val nextIntent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(nextIntent)
            }
        }


    }
}
