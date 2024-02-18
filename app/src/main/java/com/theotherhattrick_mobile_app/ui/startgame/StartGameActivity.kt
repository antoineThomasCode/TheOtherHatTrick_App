package com.theotherhattrick_mobile_app.ui.startgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class StartGameActivity : ComponentActivity() {

    val startGameViewModel = StartGameViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           StartGameScreen(
               startGameViewModel,
               Modifier
                   .padding(
                       vertical = 40.dp
                   )
           )

        }

    }
}


