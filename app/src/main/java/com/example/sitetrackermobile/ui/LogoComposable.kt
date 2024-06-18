package com.example.sitetrackermobile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sitetrackermobile.R

@Composable
fun Logos() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {


        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.TopEnd)
        )
    }
}
