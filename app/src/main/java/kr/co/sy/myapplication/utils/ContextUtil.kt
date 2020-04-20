package kr.co.sy.myapplication.utils

import android.content.Context
import android.content.SharedPreferences

//나쁘지 않았지만, 싱글톤으로 SharedPreference를 관리하는 방법 알아보기 ~
//컨텍스트를 매번 던지지 않아도 된답니다.
// 그리고 Shared를 호출하는 위치가 Context를 꼭 가지고 올수 있는 위치라고 장담도 못 해요
class ContextUtil{

    private val prefName: String = "myPref"
    private val USER_TOKEN: String = "USER_TOKEN";

    fun setUserToken(context: Context, token: String?): Unit {
        val pref: SharedPreferences = context.getSharedPreferences(prefName, 0)
        pref.edit().putString(USER_TOKEN, token).apply()
    }

    fun getUserToken(context: Context): String? {
        val pref: SharedPreferences = context.getSharedPreferences(prefName, 0)
        return pref.getString(USER_TOKEN, "")
    }
}

