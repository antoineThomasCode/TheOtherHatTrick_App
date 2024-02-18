package com.theotherhattrick_mobile_app.ui.ingame

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InGame(
    inGameViewModel: InGameViewModel
) {
    Column (
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
        Text(text = "La partie commencer !")

        Text(text = inGameViewModel.iAm)
        inGameViewModel.game.players.forEach{
            player ->
            Text(text = player.name)
        }
    }

}
