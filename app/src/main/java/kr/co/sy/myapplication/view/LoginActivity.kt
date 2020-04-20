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


    fun loginApi(){
        //백그라운드 스래드에서 네트워크 작업 하기
        //그리고 작업은 펑션 분리하라그랬어요~
        val id = binding.editId.text.toString()
        val password = binding.editPassword.text.toString()

        network?.server?.loginAccount(id, password)?.enqueue(object : Callback<AuthEntity> {
            override fun onFailure(call: Call<AuthEntity>?, t: Throwable?) { //아예 네트워킹의 익셉션
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<AuthEntity>?, response: Response<AuthEntity>?) {
                if (response != null) { // 보통 리스폰이 Null일 경우는 없기 때문에  이 코드는 과잉 코드 지만, 나쁜건 아니에요
                    // 코딩을 해 나가면서 response!=null 이런 코드를 앞으로도 계속 작성할지 말지는 스스로 판단 해보셔요~

                    if (response.isSuccessful) { //JS : 웹 리스폰이 200 일때
                        val result: AuthEntity? = response.body()
                        ContextUtil().setUserToken(applicationContext, result?.data?.token)

                        val nextIntent = Intent(applicationContext, PagerActivity::class.java)
                        startActivity(nextIntent)
                        //기존 액티비티는 종료를 안 시키는 정책인가요?


                    } else { // 웹 리스폰이 200이 아닐때 / fail
                        Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    fun goSignUpActivity(){
        val nextIntent = Intent(applicationContext, SignupActivity::class.java)
        startActivity(nextIntent)
        //기존 액티비티는 종료를 안 시키는 정책인가요?
    }


    //클릭리스너에 각각 다른성격의 기능을 해야한다면 메서드 단위로 기능을 나누고
    //클릭리스너에서는 호출만 간결하게 할수 있도록 습관을 가지세요
    override fun onClick(v: View?) {
        when (v?.id) {
            binding.loginButton.id -> {
                loginApi()
            }
            binding.signupButton.id-> {
                goSignUpActivity()
            }
        }
    }

}
