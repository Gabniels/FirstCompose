package com.example.allincompose.screen.coin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.allincompose.components.TextTitle
import com.example.allincompose.screen.coin.ui.theme.AllinComposeTheme

class CoinActivity : ComponentActivity() {

    private val viewModel: CoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllinComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoinContent(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun CoinContent(viewModel: CoinViewModel) {
    Column() {
        TextTitle(message = "List Crypto Coin")
        ListCoinScreen(viewModel = viewModel)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    AllinComposeTheme {

    }
}