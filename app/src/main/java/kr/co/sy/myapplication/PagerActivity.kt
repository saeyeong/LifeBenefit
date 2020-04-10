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
    var pager: ViewPager? = null
    var getCount: Int? = null
    var tab: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pager)

        getCount = 5
        tabAdapter = TabAdapter(supportFragmentManager, getCount!!)

        pager = binding.container
        pager?.adapter = tabAdapter

        tab = binding.tabLayout
        tab?.setupWithViewPager(pager)

    }
}
