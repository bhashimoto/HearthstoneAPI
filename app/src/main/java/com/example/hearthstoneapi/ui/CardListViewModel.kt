package com.example.hearthstoneapi.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

@Composable
fun CardList(modifier: Modifier = Modifier) {
    LazyColumn {
        items(5) { index ->
            CardListItem(name = index.toString())
        }
    }
}

class CardListViewModel() : ViewModel() {

}

@Composable
fun CardListItem(name: String, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1.0F)
            .padding(horizontal = 10.dp)
            .padding(vertical = 5.dp),
        onClick = { PingLog(name) }
    ) {
        Text(
            text = name,
            modifier = Modifier
                .padding(10.dp)
        )

    }
}

fun PingLog(msg: String) {
    Log.i("PingLog", msg)
}

