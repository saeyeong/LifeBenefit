package kr.co.sy.myapplication.Fragmanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kr.co.sy.myapplication.R


class BlankFragment4 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    var textTitleView: TextView? = null
    var textContentsView: TextView? = null
    lateinit var layoutView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            textTitleView = layoutView.findViewById(R.id.text_title)
            textContentsView = layoutView.findViewById(R.id.text_contents)

            textTitleView?.text = param1
            textContentsView?.text = param2
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_blank4, container, false)
        return layoutView
    }

    companion object {
        const val ARG_PARAM1 = "param1"
        const val ARG_PARAM2 = "param2"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
