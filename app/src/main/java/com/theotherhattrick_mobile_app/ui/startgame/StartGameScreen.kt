package com.theotherhattrick_mobile_app.ui.startgame




import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antoinethomas.theotherhattrick_mobile_app.R
import com.theotherhattrick_mobile_app.ui.ingame.InGameActivity

@Composable
fun StartGameScreen(
    viewModel: StartGameViewModel,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        var playerOneNameInput by remember {
            mutableStateOf("")
        }
        var playerTwoNameInput by remember {
            mutableStateOf("")
        }
        var playerThreeNameInput by remember {
            mutableStateOf("")
        }
        Text(
            text = "Bienvenur dans le jeu\nThe Other Hat Trick",
            modifier = Modifier
                .padding(12.dp, 60.dp, 40.dp, 12.dp)
                .fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = 40.sp)

        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,

        ) {
            Image(
                painter = painterResource(id = R.drawable.the_other_hat_trick_ok),
                contentDescription = "test",

                )
        }
        Text(
            text = "Commençons à par configurer la partie",
            modifier = Modifier
                .padding(12.dp, 50.dp, 40.dp, 12.dp)
                .fillMaxWidth(),
            fontSize = 23.sp,
            fontWeight = FontWeight.Black,

        )
        Text(
            text = "Entrez le nom des joueurs ou 'IA' pour créer une IA",
            modifier = Modifier
                .padding(12.dp, 60.dp, 40.dp, 12.dp),
            fontSize = 20.sp

        )

        Text(
            text = "Joueur N°1",
            modifier = Modifier
                .padding(12.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )
        TextField(
            value = playerOneNameInput,
            onValueChange = {
                playerOneNameInput = it
                viewModel.onUiEvent(StartGameUiEvent.PlayerOneNameChanged(name = it))
            },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        )


        Text(
            text = "Joueur N°2",
            modifier = Modifier
                .padding(12.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )
        TextField(
            value = playerTwoNameInput,
            onValueChange = {
                playerTwoNameInput = it
                viewModel.onUiEvent(StartGameUiEvent.PlayerTwoNameChanged(name = it))
            },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Joueur N°3",
            modifier = Modifier
                .padding(12.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )
        TextField(
            value = playerThreeNameInput,
            onValueChange = {
                playerThreeNameInput = it
                viewModel.onUiEvent(StartGameUiEvent.PlayerThreeNameChanged(name = it))
            },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        )
        if (viewModel.isErrorMessageDisplay) {
            Text(text = "Vous devez renseigner le nom des joueur avant de commander la partie")
        }
        
        Button(
            onClick = {
                viewModel.onUiEvent(StartGameUiEvent.StartGameClicked())
                if (viewModel.isReadyToStartGame) {
                    // Convertir la liste des joueurs en ArrayList pour la passer via l'intent
                    val playersArrayList = ArrayList(viewModel.playersList)

                    val intent = Intent(context, InGameActivity::class.java).apply {
                        putStringArrayListExtra("playersList", playersArrayList)
                    }
                    context.startActivity(intent)
                }
            },
            modifier = Modifier.padding(12.dp)

        ) {
            Text(
                text = "Commencer la partie ",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}