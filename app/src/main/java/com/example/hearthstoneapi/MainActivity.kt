package com.example.hearthstoneapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hearthstoneapi.ui.CardDetailApp
import com.example.hearthstoneapi.ui.CardDetailScreen
import com.example.hearthstoneapi.ui.CardList
import com.example.hearthstoneapi.ui.theme.HearthstoneAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HearthstoneAPITheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
                    CardDetailApp("EX1_572")
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HearthstoneAPITheme {
        CardDetailApp("EX1_572")
    }
}