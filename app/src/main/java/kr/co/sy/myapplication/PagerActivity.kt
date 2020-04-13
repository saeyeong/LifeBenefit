package kr.co.sy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kr.co.sy.myapplication.databinding.ActivityPagerBinding

class PagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagerBinding
    var tabAdapter: TabAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pager)
        init()
    }


    fun init() { //기타 필요한 초기값들을 생성하는 메서드
        tabAdapter = TabAdapter(supportFragmentManager)
        binding.container.adapter = tabAdapter
        binding.tabLayout.setupWithViewPager(binding.container)
    }

    override fun onStart() {
        super.onStart()
    }
}
