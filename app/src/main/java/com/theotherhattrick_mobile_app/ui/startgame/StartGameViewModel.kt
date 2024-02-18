package com.theotherhattrick_mobile_app.ui.startgame

import androidx.lifecycle.ViewModel


class StartGameViewModel : ViewModel() {
    var playersList : MutableList<String> = mutableListOf()
    var isReadyToStartGame = false
    var isErrorMessageDisplay = false
    private var playerOneName : String? = null
    private var playerTwoName : String? = null
    private var playerThreeName : String? = null

    fun onUiEvent(event: StartGameUiEvent) {
        when (event) {
            is StartGameUiEvent.PlayerOneNameChanged -> {
                playerOneName = event.name
            }
            is StartGameUiEvent.PlayerTwoNameChanged -> {
                playerTwoName = event.name
            }
            is StartGameUiEvent.PlayerThreeNameChanged -> {
                playerThreeName = event.name
            }
            is StartGameUiEvent.StartGameClicked -> {
                if (playerOneName != "" && playerTwoName != "" && playerThreeName != "") {
                    if(playerOneName != null && playerTwoName != null && playerThreeName != null) {
                        playersList.add(playerOneName!!)
                        playersList.add(playerTwoName!!)
                        playersList.add(playerThreeName!!)
                        isErrorMessageDisplay = false
                        isReadyToStartGame = true

                    } else {
                        isErrorMessageDisplay = true
                    }
                } else {
                    isErrorMessageDisplay = true
                }
            }
        }
    }
}