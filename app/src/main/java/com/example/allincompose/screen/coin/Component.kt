package com.example.allincompose.screen.coin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.allincompose.model.CoinResponse

@Composable
fun ListCoinScreen(viewModel: CoinViewModel) {

    val dataCoin by viewModel.coins.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCoins()
    }

    if (dataCoin.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color.Blue)
        }
    } else {
        CoinItem(item = dataCoin)
    }
}

@Composable
fun CoinItem(item: List<CoinResponse>?) {
    val textStyle = TextStyle(fontWeight = FontWeight.Normal)
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        if (!item.isNullOrEmpty()) {
            itemsIndexed(item) { index, item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = item.symbol)
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = item.name, style = textStyle)
                        Text(text = item.rank.toString())
                    }
                }
                Divider()
            }
        }
    }
}