package com.luthfy.attackontitan.Navigasi

sealed class Screen(val route : String){
    object Screen1 : Screen("Screen1")
    object Screen2 : Screen("Screen2")
    object Screen3 : Screen("Screen3")
    object detailScreen : Screen("detailScreen")
}