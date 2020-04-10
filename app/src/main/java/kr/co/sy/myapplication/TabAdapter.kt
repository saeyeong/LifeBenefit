package kr.co.sy.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.co.sy.myapplication.Fragmanet.*

class TabAdapter(fm: FragmentManager, val getCount: Int) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = getCount

    override fun getItem(position: Int): Fragment {
        val fragment = when(position)
        {
            1 -> return BlankFragment2()
            2 -> return BlankFragment3()
            3 -> return BlankFragment4()
            4 -> return BlankFragment5()
            else -> return BlankFragment1()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}
