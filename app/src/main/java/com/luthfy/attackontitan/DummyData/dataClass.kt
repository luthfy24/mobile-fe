package com.luthfy.attackontitan.DummyData

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.luthfy.attackontitan.Navigasi.Screen

data class Titan(
val id: Int,
val name: String,
val tempat: String,
val pemilik: String,
val pic: Int = 0,
val desc:String,
val color: Color,
)

data class bottomNav(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
    )

