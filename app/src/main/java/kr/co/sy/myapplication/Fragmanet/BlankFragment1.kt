package kr.co.sy.myapplication.Fragmanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_blank1.*
import kr.co.sy.myapplication.NewsModel
import kr.co.sy.myapplication.PagerActivity
import kr.co.sy.myapplication.R
import kr.co.sy.myapplication.adapter.NewsAdapter


class BlankFragment1 : Fragment() {
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
        val newsList = arrayListOf<NewsModel>()
        newsList.add(
            NewsModel(
                "경찰, 텔레그램 이용 디지털성범죄 ‘박사’ 포함 124명 검거 - 중앙일보 - 중앙일보",
                "22일 경찰청에 따르면 경찰은 지난해 9월부터 ‘n번방’으로 대표되는 텔레그램 성 착취 대화방에 대한 수사를 벌인 결과 이달 20일까지 총 124명을 검거했다. 22일 청와대 국민청원 홈페이지에 따르면 ‘텔레그램 n번방 용의자 신상공개 및 포토라인 세워주세요’ 청원은 이날 오후 5시30분 현재 190만여 명의 동의를 받았",
                "뉴스키워드1테스트",
                "뉴스키워드2테스트",
                "뉴스키워드3테스트"
            )
        )
        val adapter = NewsAdapter(newsList)
        newsListView.adapter = adapter
        newsListView.layoutManager = LinearLayoutManager(activity)


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_blank1, container, false)
        return layoutView
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
