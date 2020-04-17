package kr.co.sy.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.adapter.TabAdapter
import kr.co.sy.myapplication.databinding.ActivityPagerBinding

class PagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagerBinding
    var tabAdapter: TabAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_pager
        )
        init()
    }


    fun init() { //기타 필요한 초기값들을 생성하는 메서드
        tabAdapter =
            TabAdapter(supportFragmentManager)
        binding.container.adapter = tabAdapter
        binding.tabLayout.setupWithViewPager(binding.container)
    }

    override fun onStart() {
        super.onStart()
    }

}
