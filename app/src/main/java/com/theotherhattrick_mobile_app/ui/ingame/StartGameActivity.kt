package com.theotherhattrick_mobile_app.ui.ingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theotherhattrick_mobile_app.ui.startgame.StartGameScreen


class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Game()
            
        }

    }
}
@Composable
fun Game(modifier: Modifier = Modifier) {
    // TODO -> Fairer 3 activity distincts avec 3 view Modèle distincts


    Column {
        Text(text = "je suis un petit texte sympa")
        StartGameScreen(
            Modifier
                .padding(
                    vertical = 40.dp
                )
        ) {

        }
    }

}
