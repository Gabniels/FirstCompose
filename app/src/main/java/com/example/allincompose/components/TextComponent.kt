package com.example.allincompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.allincompose.ui.theme.softBlue

@Composable
fun TextTitleOne(message: String, color : Color) {
    Text(
        text = message,
        style = TextStyle(
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Justify,
            fontSize = 12.sp,
            color = color,
            fontWeight = FontWeight.Bold
        ),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Monospace,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextTitleTwo(message: String) {
    Text(
        text = message, style = TextStyle(
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Justify,
            fontSize = 12.sp,
            color = Color.White,
        )
    )
}


@Composable
fun TextTitle(message: String) {
    Text(
        text = message,
        textAlign = TextAlign.Center, style = TextStyle(
            color = softBlue,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    )
}