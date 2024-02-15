package com.theotherhattrick_mobile_app.ui.startgame

import Model.Player.Player
import androidx.lifecycle.ViewModel

class StartGameViewModel : ViewModel() {
    var players : List<Player>? = null

    var gameIsRunning = false

}