package com.keepcoding.appfinal.presentation.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.keepcoding.appfinal.R

@Composable
fun TabScreen(
    pantalla1: (@Composable () -> Unit),
    pantalla2: (@Composable () -> Unit),
    ) {

    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Home", "My acount")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = tabIndex,
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.Magenta),
            backgroundColor = colorResource(id = R.color.colorPpalBlue)
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            color = androidx.compose.ui.graphics.Color.White,
                            fontSize = 13.sp
                        ) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    icon = {
                        when (index) {
                            0 -> Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Colección",
                                    tint = Color.White
                                )
                            1 -> Icon(
                                    painterResource(id = R.drawable.icon_person),
                                    contentDescription = "Mi cuenta",
                                    tint = Color.White
                                )
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> pantalla1()
            1 -> pantalla2()
        }
    }
}