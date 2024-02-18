package com.theotherhattrick_mobile_app.ui.startgame


sealed class StartGameUiEvent {
    data class PlayerOneNameChanged(val name: String) : StartGameUiEvent()
    data class PlayerTwoNameChanged(val name: String) : StartGameUiEvent()
    data class PlayerThreeNameChanged(val name: String) : StartGameUiEvent()

    class StartGameClicked() : StartGameUiEvent()


}