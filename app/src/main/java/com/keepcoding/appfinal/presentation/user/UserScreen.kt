package com.keepcoding.appfinal.presentation.user

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.appfinal.R

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun UserScreen() {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    var expandedState2 by remember {
        mutableStateOf(false)
    }
    val rotationState2 by animateFloatAsState(
        targetValue = if (expandedState2) 180f else 0f
    )

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Spacer(modifier = Modifier.size(40.dp))

        Image(
            modifier = Modifier
                .size(150.dp),
            painter = painterResource(id = R.drawable.user),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec =
                    tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            onClick = {
                expandedState = !expandedState
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier
                            .weight(6f),
                        text = "My movies",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .alpha(ContentAlpha.medium)
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                        }) {

                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down Arrow"
                        )
                    }
                }
                if (expandedState) {
                    Text(
                        text = "Barbie \nTransformers \nOpenhaimer",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 35.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.size(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec =
                    tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            onClick = {
                expandedState2 = !expandedState2
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier
                            .weight(6f),
                        text = "My favorites",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .alpha(ContentAlpha.medium)
                            .rotate(rotationState),
                        onClick = {
                            expandedState2 = !expandedState2
                        }) {

                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down Arrow"
                        )
                    }
                }
                if (expandedState2) {
                    Text(
                        text = "Barbie \nTransformers \nOpenhaimer",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 35.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(180.dp)
        ) {

            Text(
                text = "My data",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(180.dp)
        ) {

            Text(
                text = "Preferences",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
