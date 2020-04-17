package kr.co.sy.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.loginButton.setOnClickListener(this)

        //Retrofit
        var retrofit = Retrofit.Builder()
        .baseUrl("http://question.api-namu.kro.kr:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        server = retrofit.create(ApiService::class.java)


    }

    override fun onClick(v: View?) {
        Log.d("test","click test")
        val id = binding.editId.text.toString()
        val password = binding.editPassword.text.toString()

        server?.loginAccount(id,password)?.enqueue(object : Callback<Auth> {
            override fun onFailure(call: Call<Auth>?, t: Throwable?) {
                Log.e("SSS", t.toString())
            }

            override fun onResponse(call: Call<Auth>?, response: Response<Auth>?) {
                Log.d("SSS", response?.body().toString())

                val nextIntent = Intent(applicationContext, PagerActivity::class.java)
                startActivity(nextIntent)
            }
        })

    }
}
