package com.theotherhattrick_mobile_app.ui.ingame

import Model.Game.Game
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


class InGameActivity (

): ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val playersList = intent.getStringArrayListExtra("playersList") ?: listOf<String>()
        val game = Game(playersList)

        val inGameViewModel = InGameViewModel(game)

        setContent {
            InGameScreen(inGameViewModel)

        }

    }
}
@Composable
fun InGameScreen(
     inGameViewModel: InGameViewModel
) {
    // TODO -> Fairer 3 activity distincts avec 3 view Modèle distincts


    Column {

        InGame(inGameViewModel)
    }

}