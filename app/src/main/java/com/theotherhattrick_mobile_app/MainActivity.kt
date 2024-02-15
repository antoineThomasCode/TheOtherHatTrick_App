package com.antoinethomas.theotherhattrick_mobile_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.theotherhattrick_mobile_app.ui.ingame.StartActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
        finish()
    }
}
