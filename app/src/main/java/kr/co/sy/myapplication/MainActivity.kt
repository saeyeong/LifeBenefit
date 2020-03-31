package kr.co.sy.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    var button :Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val builder = AlertDialog.Builder(this)

        button= findViewById(R.id.button)
        button?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        Toast.makeText(this,"로그인 해라",Toast.LENGTH_LONG).show()
        val nextIntent = Intent(this, Main2Activity::class.java)
        startActivity(nextIntent)
    }

}
