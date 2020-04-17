package kr.co.sy.myapplication.model

import kr.co.sy.myapplication.model.entity.NewsEntity

class DataModel {
    var itemsList: ArrayList<NewsEntity>? = null
        get() = field ?: ArrayList()

    init {
        itemsList = makeTestItems()
    }

    fun makeTestItems(): ArrayList<NewsEntity> {
        var items = ArrayList<NewsEntity>()
        for (i in 0..10) {
            var item = NewsEntity(
                "${i}번째 아이템 경찰, 텔레그램 이용 디지털성범죄 ‘박사’ 포함 124명 검거 - 중앙일보 - 중앙일보",
                "22일 경찰청에 따르면 경찰은 지난해 9월부터 ‘n번방’으로 대표되는 텔레그램 성 착취 대화방에 대한 수사를 벌인 결과 이달 20일까지 총 124명을 검거했다. 22일 청와대 국민청원 홈페이지에 따르면 ‘텔레그램 n번방 용의자 신상공개 및 포토라인 세워주세요’ 청원은 이날 오후 5시30분 현재 190만여 명의 동의를 받았",
                "뉴스키워드1테스트",
                "뉴스키워드2테스트",
                "뉴스키워드3테스트"
            )
            items.add(item)
        }

        return items
    }
}