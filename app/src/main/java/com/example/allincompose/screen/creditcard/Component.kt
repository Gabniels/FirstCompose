package com.example.allincompose.screen.creditcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.allincompose.model.CreditCardResponse
import com.example.allincompose.ui.theme.softBlue

@Composable
fun CreditCardView(viewModel: CreditCardViewModel) {
    val creditCards by viewModel.creditCards.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getCreditCards()
    }

    if (creditCards == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color.Blue)
        }
    } else {
        CreditCardItem(creditCards = creditCards)
    }

}

@Composable
fun CreditCardItem(creditCards: CreditCardResponse?) {
    val textStyle = TextStyle(
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,
        fontSize = 12.sp
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)

    ) {
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
                Text(text = "Id : " + creditCards?.id.toString(), style = textStyle)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Uid : " + creditCards?.uid.toString(), style = textStyle)
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "CC Number :" + creditCards?.credit_card_number.toString(),
                    style = textStyle
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "CC Expire : " + creditCards?.credit_card_expiry_date.toString(),
                    style = textStyle
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "CC Type : " + creditCards?.credit_card_type.toString(),
                    style = textStyle
                )
            }
        }
    }
}