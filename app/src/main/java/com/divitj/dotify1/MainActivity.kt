package com.divitj.dotify1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var btnPrevSong: ImageButton
    private lateinit var btnNextSong: ImageButton
    private lateinit var btnPlay: ImageButton
    private val randomNumber = Random.nextInt(100, 10000)
    private lateinit var tvNumberPlays: TextView
    private lateinit var etChangeUser: EditText
    private lateinit var tvCurrUser: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrevSong = findViewById(R.id.ibPrevBtn)
        btnNextSong = findViewById(R.id.ibNextBtn)
        tvNumberPlays = findViewById(R.id.tvNumPlays)
        btnPlay = findViewById(R.id.ibPlayBtn)
        etChangeUser = findViewById(R.id.etUsername)
        tvCurrUser = findViewById(R.id.tvCurrUser)

        btnPrevSong.setOnClickListener{
            Toast.makeText(this, "Skipping to previous track", Toast.LENGTH_SHORT).show()
        }

        btnNextSong.setOnClickListener{
            Toast.makeText(this, "Skipping to next track", Toast.LENGTH_SHORT).show()
        }

        var plays = randomNumber
        tvNumberPlays.text = "${plays.toString()} plays"

        btnPlay.setOnClickListener{
            plays += 1
            tvNumberPlays.text = "${plays.toString()} plays"
        }
    }
}