package kr.co.sy.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.databinding.ActivityMainBinding
import kr.co.sy.myapplication.utils.ContextUtil

class MainActivity : AppCompatActivity() ,View.OnClickListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.button.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
       // if(ContextUtil().getUserToken(applicationContext).equals("")) { //토큰이 Null일 때는 검사를 안 하나용?
        if(ContextUtil().getUserToken(applicationContext).isNullOrEmpty()) {
            //그리고 스트링 empty 검사는 isEmpty라는 메서드가 있고  코틀린에서는
            val nextIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextIntent)
        } else {
            Toast.makeText(applicationContext, ContextUtil().getUserToken(applicationContext), Toast.LENGTH_LONG).show()
            val nextIntent = Intent(this, PagerActivity::class.java)
            startActivity(nextIntent)
        }

        //여기서도 마찬가지로 기존 액티비티는 계속 살려놓는 정책인가요?
    }
}
