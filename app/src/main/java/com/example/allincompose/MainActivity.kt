package com.example.allincompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.allincompose.screen.creditcard.CreditCardActivity
import com.example.allincompose.screen.placeholder.PlaceholderActivity
import com.example.allincompose.ui.theme.AllinComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllinComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue,
                    ) {
                    ListMenu()
                }
            }
        }
    }
}

@Composable
fun ListMenu() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.background(Color.White),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            context.startActivity(Intent(context, CreditCardActivity::class.java))
        }
        ) {
            Text(text = "Credit Card", style = TextStyle(color = Color.White))
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, PlaceholderActivity::class.java))
            }) {
            Text(text = "Json Placeholder", style = TextStyle(color = Color.White))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AllinComposeTheme {
        ListMenu()
    }
}