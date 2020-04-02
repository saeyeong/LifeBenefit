package kr.co.sy.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_bottom_navi.*
import java.util.*

class BottomNaviActivity : AppCompatActivity(), View.OnClickListener {

    var button1: Button? = null
    var button2: Button? = null
    var fm: FragmentManager? = null
    var ft: FragmentTransaction? = null
    var currentFragmentTag: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navi)

        //
        supportFragmentManager.let {
            fm = it
            ft = it.beginTransaction()

        }


        button1 = findViewById(R.id.button1)
        button1?.setOnClickListener(this)

        button2 = findViewById(R.id.button2)
        button2?.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        firstInitFragment()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                replaceFragment(BlankFragment1.newInstance("블랭크1파람1", "블랭크1파람2"))
            }
            R.id.button2 -> {
                replaceFragment(BlankFragment2.newInstance("블랭크2파람1", "블랭크2파람2"))
            }
        }

    }

    fun firstInitFragment() {
        replaceFragment(BlankFragment1.newInstance("블랭크1파람1", "블랭크1파람2"))
    }


    fun replaceFragment(fragment: Fragment?) {
        fragment?.let {
            if (isCurrentFragmentEqual(it)) { //같은 화면을 눌렀을떈 새로 띄우는 일을 하지 않음

            } else {
                currentFragmentTag = fragment::class.java.simpleName
                ft= fm?.beginTransaction()
                ft?.replace(R.id.container, it)
                ft?.addToBackStack(null)
                ft?.commit()
            }
        }
    }

    fun isCurrentFragmentEqual(fragment: Fragment): Boolean { // 현재 프래그먼트의 태그와 바꾸길 원하는 프래그먼트의 태그를 비교함
        currentFragmentTag?.let {
            return currentFragmentTag == fragment::class.java.simpleName
        } ?: run {
            return false
        }
    }

    override fun onBackPressed() {
        fm?.let {
            if (it.fragments.size > 1) {
                super.onBackPressed()
            } else {
                finish()
            }
            return
        }
        super.onBackPressed()
    }

}
