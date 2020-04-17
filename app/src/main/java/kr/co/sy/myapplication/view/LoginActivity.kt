package kr.co.sy.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import kr.co.sy.myapplication.network.ApiService
import kr.co.sy.myapplication.model.entity.AuthEntity
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    var server: ApiService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )


        init()

    }

    fun init(){

        //Retrofit
        //JS : 따로 네트워크 전용 클래스, 만들어서 핸들링 할 것 이렇게 하면 매~~번 retrofit객체를 이닛 해야하니까
        //매우 불필요
        var retrofit = Retrofit.Builder()
            .baseUrl("http://question.api-namu.kro.kr:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        server = retrofit.create(ApiService::class.java)

        setListener()
    }

    fun setListener(){
        binding.loginButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Log.d("test","click test")
        val id = binding.editId.text.toString()
        val password = binding.editPassword.text.toString()

        server?.loginAccount(id,password)?.enqueue(object : Callback<AuthEntity> {
            override fun onFailure(call: Call<AuthEntity>?, t: Throwable?) { //아예 네트워킹의 익셉션
                Log.e("SSS", t.toString())
            }

            override fun onResponse(call: Call<AuthEntity>?, response: Response<AuthEntity>?) {
              /*  response?.let {
                    if(it.isSuccessful){ //JS : 웹 리스폰이 200 일때

                    }
                    else{ // 웹 리스폰이 200이 아닐때 / fail

                    }
                }*/
                Log.d("SSS", response?.body().toString())

                val nextIntent = Intent(applicationContext, PagerActivity::class.java)
                startActivity(nextIntent)
            }
        })

    }
}
