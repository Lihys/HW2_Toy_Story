package com.example.hw1_toy_story

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val gameModeSelector = findViewById<RadioGroup>(R.id.mode_radio_group)
        val btnStart = findViewById<Button>(R.id.btn_start_game)
        val btnLeaderboard = findViewById<Button>(R.id.btn_leaderboard)

        btnStart.setOnClickListener {
            //set the settings based on the user's choice
            val selectedModeId = gameModeSelector.checkedRadioButtonId

            var useTilt = false
            var gameSpeed = 600L // default/slow

            when (selectedModeId) {
                R.id.radio_tilt -> {
                    useTilt = true
                    gameSpeed = 600L
                }
                R.id.radio_arrows_easy -> {
                    useTilt = false
                    gameSpeed = 600L
                }
                R.id.radio_arrows_hard -> {
                    useTilt = false
                    gameSpeed = 300L // half, fast
                }
            }

            // launching Main Activity and passing our settings
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("USE_TILT", useTilt)
                putExtra("GAME_SPEED", gameSpeed)
            }
            startActivity(intent)
        }

        btnLeaderboard.setOnClickListener {
            // to change of course:
            Toast.makeText(this, "Leaderboard screen coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}