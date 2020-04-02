package kr.co.sy.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bottom_navi.*

class BottomNaviActivity : AppCompatActivity() , View.OnClickListener{

    var button1 : Button?= null
    var button2 : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navi)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment,BlankFragment1()).commit()

        button1 = findViewById(R.id.button1)
        button1?.setOnClickListener(this)

        button2 = findViewById(R.id.button2)
        button2?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val ft = supportFragmentManager.beginTransaction()

        when(v?.id){
            R.id.button1-> {
                ft.replace(R.id.fragment, BlankFragment1()).addToBackStack(null).commit()
            }
            R.id.button2-> {
                ft.replace(R.id.fragment, BlankFragment2()).addToBackStack(null).commit()
            }
        }

    }
}
