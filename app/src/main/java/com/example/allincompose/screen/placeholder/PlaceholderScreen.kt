package com.example.allincompose.screen.placeholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.allincompose.ui.theme.AllinComposeTheme
import com.example.allincompose.ui.theme.softBlue

class PlaceholderActivity : ComponentActivity() {

    private val viewModel: PlaceholderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllinComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column {
                        Text(
                            text = "List Placeholder",
                            textAlign = TextAlign.Center, style = TextStyle(
                                color = softBlue,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        )
                        PlaceholderScreen(viewModel = viewModel)
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AllinComposeTheme {

    }
}