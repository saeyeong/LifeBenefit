package kr.co.sy.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.co.sy.myapplication.Fragmanet.*
import kr.co.sy.myapplication.utils.Const

class TabAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragmentList: ArrayList<Fragment>? = null

    init {
        fragmentList = ArrayList()
        makeTempPage()
    }

    override fun getCount(): Int = fragmentList?.let {
        return@let it.size
    } ?: kotlin.run {
        return 0
    }

    override fun getItem(position: Int): Fragment {
        fragmentList?.let {
            return it[position]
        }
        return BlankFragment1.newInstance("", "")
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "${Const.TAB_NAME_PREFIX} ${(position + 1)}"
    }


    fun addToListFragmentItem(fragment: Fragment) {
        fragmentList?.let {
            it.add(fragment)
        }
    }

    fun makeTempPage() {
        fragmentList?.let {
            addToListFragmentItem(BlankFragment1.newInstance("sdfsdf", "sdfsdf"))
            addToListFragmentItem(BlankFragment2.newInstance("sdfsdf", "sdfsdf"))
            addToListFragmentItem(BlankFragment3.newInstance("sdfsdf", "sdfsdf"))
            addToListFragmentItem(BlankFragment4.newInstance("sdfsdf", "sdfsdf"))
            addToListFragmentItem(BlankFragment5.newInstance("sdfsdf", "sdfsdf"))
        }

    }
}
