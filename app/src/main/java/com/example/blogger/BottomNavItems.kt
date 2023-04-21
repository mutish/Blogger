package com.example.blogger

sealed class BottomNavItems(var route: String, var icon: Int, var title: String ){
    object Music: BottomNavItems("music",R.drawable.spotify_icon,"Music")
    object Books: BottomNavItems("music",R.drawable.bookshelf_icon,"Books")
    object Movies: BottomNavItems("music",R.drawable.movie_icon,"Music")
}
