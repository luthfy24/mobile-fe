package com.luthfy.attackontitan.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.luthfy.attackontitan.DummyData.ShingekyData
import com.luthfy.attackontitan.Layout.detailLayout
import com.luthfy.attackontitan.Layout.gridLayout

@Composable
fun detailScreen(
    titanId : Int?
){
    val newTitanList = ShingekyData.titan.filter {
        it.id == titanId
    }
    Column {
        if (titanId != null && newTitanList.isNotEmpty()) {
            detailLayout(newTitanList = newTitanList)
        } else {
            Text(text = "Makanan Tidak Ditemukan")
        }
    }
}


