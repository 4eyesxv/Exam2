package com.example.exam.storage

import android.content.Context
import androidx.fragment.app.FragmentActivity

class SharedPreference(context: FragmentActivity) {
    private val PREFERENCE_FILE = "SharedPreference"

    private val APP_PREF_LOGIN = "Login"
    private val APP_PREF_PASSWORD = "Password"
    private val preference = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE)

    var login: String?
        get() = preference.getString(APP_PREF_LOGIN, null)
        set(value) = preference.edit().putString(APP_PREF_LOGIN, value).apply()

    var password: String?
        get() = preference.getString(APP_PREF_PASSWORD, null)
        set(value) = preference.edit().putString(APP_PREF_PASSWORD, value).apply()
}