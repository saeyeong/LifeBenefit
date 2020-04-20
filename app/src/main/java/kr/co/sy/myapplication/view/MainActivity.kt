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
        if(ContextUtil().getUserToken(applicationContext).equals("")) {
            val nextIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextIntent)
        } else {
            Toast.makeText(applicationContext, ContextUtil().getUserToken(applicationContext), Toast.LENGTH_LONG).show()
            val nextIntent = Intent(this, PagerActivity::class.java)
            startActivity(nextIntent)
        }
    }
}
