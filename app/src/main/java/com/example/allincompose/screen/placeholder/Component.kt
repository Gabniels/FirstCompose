package com.example.allincompose.screen.placeholder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.allincompose.components.TextTitleOne
import com.example.allincompose.components.TextTitleTwo
import com.example.allincompose.model.PlaceholderResponse
import com.example.allincompose.ui.theme.softBlue

@Composable
fun PlaceholderScreen(viewModel: PlaceholderViewModel) {
    val dataPlaceholder by viewModel.placeholder.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getPlaceholder()
    }

    if (dataPlaceholder == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color.Blue)
        }
    } else {
        PlaceholderItem(item = dataPlaceholder)
    }

}

@Composable
fun PlaceholderItem(item: List<PlaceholderResponse>?) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        if (!item.isNullOrEmpty()) {
            itemsIndexed(item) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .background(softBlue)
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        TextTitleOne(message = item.title.toString(), color = Color.White)
                        Spacer(modifier = Modifier.height(15.dp))
                        TextTitleTwo(message = item.body.toString())
                    }
                }
            }
        }

    }

}