package com.example.allincompose.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

object ViewUtils {

    @Composable
    fun ButtonMenu(onCLick: () -> Unit, txt: String) {
        Button(
            onClick = { onCLick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 5.dp)
        ) {
            Text(text = txt, style = TextStyle(Color.White))
        }
    }
}