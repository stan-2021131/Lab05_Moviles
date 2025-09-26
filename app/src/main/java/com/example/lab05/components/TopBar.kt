package com.example.lab05.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05.R

@Composable
fun TopBar(title: String, isBack: Boolean, onClick: ()->Unit){
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(70.dp)
            .background(color = Color(0xFFD32F2F)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isBack){
            IconButton(
                modifier = Modifier.padding(start = 5.dp, top = 25.dp),
                onClick = onClick
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.arrowBackDescription)
                )

            }
        }
        Text(
            text = title,
            modifier = Modifier.padding(start = 10.dp, top = 25.dp),
            fontSize = 30.sp
        )
    }
}