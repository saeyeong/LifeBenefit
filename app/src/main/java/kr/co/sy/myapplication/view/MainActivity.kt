package kr.co.sy.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.databinding.ActivityMainBinding

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

        Toast.makeText(this,"로그인 해라",Toast.LENGTH_LONG).show()
        val nextIntent = Intent(this, LoginActivity::class.java)
        startActivity(nextIntent)
    }

}
