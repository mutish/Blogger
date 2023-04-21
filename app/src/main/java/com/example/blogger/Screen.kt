package com.example.blogger

sealed class Screen(var route: String, var icon: Int, var title: String ){
    object User: Screen("user",R.drawable.profile_icon,"User")
    object Dashboard: Screen("dashboard",R.drawable.dashboard_icon,"Dashboard")
    object Shortcuts: Screen("shortcut",R.drawable.shortcut_ios_icon,"Shortcut")
    object About: Screen("about",R.drawable.myabout,"About")
    object Contact: Screen("contact",R.drawable.myandroid_icon,"Contact Me")

}
