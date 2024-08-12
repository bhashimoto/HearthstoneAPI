package com.example.hearthstoneapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.hearthstoneapi.R
import com.example.hearthstoneapi.network.CardDetail

@Composable
fun CardDetailApp(cardId: String) {
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        val cardViewModel = CardViewModel(cardId)
        CardDetailScreen(
            cardId = cardId,
            cardUiState = cardViewModel.cardUiState,
            retryAction = cardViewModel::getCardDetails

        )

    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.placeholder_image),
        contentDescription = "Loading"
    )
}

@Composable
fun ErrorScreen(
    retryAction: (cardId: String) -> Unit,
    cardId: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder_image), contentDescription = ""
        )
        Text(text =  "error")
        Button(onClick = {retryAction(cardId)}) {
            Text("retry")
        }
    }
}


@Composable
fun CardDetailScreen(
    cardId: String,
    cardUiState: CardUiState,
    retryAction: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (cardUiState) {
        is CardUiState.Loading -> LoadingScreen(modifier = modifier)
        is CardUiState.Success -> CardDetailLayout(card = cardUiState.card)
        is CardUiState.Error -> ErrorScreen(retryAction, cardId, modifier = modifier.fillMaxSize() )
    }
}


@Composable
fun CardDetailLayout(
    card: CardDetail,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(card.img)
                .crossfade(true)
                .build(),
            contentDescription = "Card Image",
        )
        Text(text = card.name)
        Text(text = card.flavor)
        Text(text = card.text)
        Text(text = card.cardSet)
        Text(text = card.type)
        Text(text = card.faction)
        Text(text = card.rarity)
        Text(text = "Attack: " + card.attack.toString())
        Text(text = "Cost: " + card.cost.toString())
        Text(text = "Health: " + card.health.toString())
    }
}