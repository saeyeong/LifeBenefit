package kr.co.sy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kr.co.sy.myapplication.databinding.ActivityBottomNaviBinding

class BottomNaviActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNaviBinding
    var fm: FragmentManager? = null
    var ft: FragmentTransaction? = null
    var currentFragmentTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navi)

        supportFragmentManager.let {
            fm = it
            ft = it.beginTransaction()
        }

//        binding.button1.setOnClickListener(this)
//        binding.button2.setOnClickListener(this)

        val tabAdapter = TabAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.container)
        pager.adapter = tabAdapter

        val tab = findViewById<TabLayout>(R.id.tab)
        tab.setupWithViewPager(pager)



    }
//
//    override fun onStart() {
//        super.onStart()
//        firstInitFragment()
////       첫 프래그먼트 세팅
//    }
//
//    override fun onClick(v: View?) {
//        when (v?.id) {
////            R.id.button1 -> {
////                replaceFragment(BlankFragment1.newInstance("블랭크1파람1", "블랭크1파람2"))
////            }
////            R.id.button2 -> {
////                replaceFragment(BlankFragment2.newInstance("블랭크2파람1", "블랭크2파람2"))
////            }
//        }
//
//    }
//
//    fun firstInitFragment() {
//        replaceFragment(BlankFragment1.newInstance("블랭크1파람1", "블랭크1파람2"))
//    }
//
//
//    fun replaceFragment(fragment: Fragment?) {
////       바꿀 프래그먼트를 인자로 받음
//        fragment?.let {
//            if (isCurrentFragmentEqual(it)) { //같은 화면을 눌렀을떈 새로 띄우는 일을 하지 않음
//
//            } else {
//                currentFragmentTag = fragment::class.java.simpleName // 인자로 받은(앞으로바꿀) 프래그먼트의 클래스명을 저장함
//                ft= fm?.beginTransaction()
//                ft?.replace(R.id.container, it)
//                ft?.addToBackStack(null)
//                ft?.commit()
//            }
//        }
//    }
//
//    fun isCurrentFragmentEqual(fragment: Fragment): Boolean { // 현재 프래그먼트의 태그와 바꾸길 원하는 프래그먼트의 태그를 비교함
//        currentFragmentTag?.let {
//            return currentFragmentTag == fragment::class.java.simpleName
//            // 저장되어 있는(현재 보여지는) 클래스명과 바꿀 프래그먼트의 클래스명을 비교함
//        } ?: run {
//            return false
//        } // currentFragmentTag는 처음 버튼 클릭시 아무값도 담겨져 있지않음
//    }
//
//    override fun onBackPressed() { //스택. 더이상 없으면 finish()
//        fm?.let {
//            if (it.fragments.size > 1) {
//                super.onBackPressed()
//            } else {
//                finish()
//            }
//            return
//        }
//        super.onBackPressed()
//    }

}
