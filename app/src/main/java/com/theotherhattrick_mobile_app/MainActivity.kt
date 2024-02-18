package com.antoinethomas.theotherhattrick_mobile_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.theotherhattrick_mobile_app.ui.startgame.StartGameActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, StartGameActivity::class.java)
        startActivity(intent)
        finish()
    }
}
