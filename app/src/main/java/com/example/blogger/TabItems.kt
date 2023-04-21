package com.example.blogger

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object New : TabItem(R.drawable.new_fiber_ic_icon, "New", { NewScreen() })
    object Favorites : TabItem(R.drawable.like_icon, "Favorites", { FavoritesScreen() })
    object Downloads : TabItem(R.drawable.downloaded_icon, "Downloads", { DownloadsScreen() })
}