package kr.co.sy.myapplication.Fragmanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_blank1.*
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.adapter.NewsAdapter
import kr.co.sy.myapplication.databinding.FragmentBlank1Binding
import kr.co.sy.myapplication.model.DataModel


class BlankFragment1 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    var model :DataModel? = null

    lateinit var binding :FragmentBlank1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    fun init(){
        model = DataModel()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            binding.textTitle.text=param1
            binding.textContents.text=param2

            val adapter = NewsAdapter(model?.itemsList)
            newsListView.adapter = adapter
            newsListView.layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_blank1,container,false)
        return binding.root
    }

    companion object {
        private  val ARG_PARAM1 = "param1"
        private  val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
