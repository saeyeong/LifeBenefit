package kr.co.sy.myapplication.utils

import android.content.Context
import android.content.SharedPreferences

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

