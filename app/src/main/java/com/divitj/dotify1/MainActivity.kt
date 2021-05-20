package com.divitj.dotify1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    private lateinit var btnChangeUser: Button
    private lateinit var songCoverImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrevSong = findViewById(R.id.ibPrevBtn)
        btnNextSong = findViewById(R.id.ibNextBtn)
        tvNumberPlays = findViewById(R.id.tvNumPlays)
        btnPlay = findViewById(R.id.ibPlayBtn)
        etChangeUser = findViewById(R.id.etUsername)
        tvCurrUser = findViewById(R.id.tvCurrUser)
        btnChangeUser = findViewById(R.id.btnChangeUser)
        songCoverImg = findViewById(R.id.ivCoverArt)

        etChangeUser.visibility = View.GONE

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

        btnChangeUser.setOnClickListener {
            if (btnChangeUser.text == this@MainActivity.getString(R.string.btnChangeUser)) {
                tvCurrUser.visibility = View.GONE
                etChangeUser.visibility = View.VISIBLE
                btnChangeUser.text = getString(R.string.apply)
            } else if(btnChangeUser.text == this@MainActivity.getString(R.string.apply)) {
                tvCurrUser.text = etChangeUser.text
                if (etChangeUser.text.isNullOrBlank()) {
                    Toast.makeText(this, "user name field left empty", Toast.LENGTH_SHORT).show()
                }
                etChangeUser.visibility = View.GONE
                tvCurrUser.visibility = View.VISIBLE
                btnChangeUser.text = getString(R.string.btnChangeUser)
            }
        }

        songCoverImg.setOnLongClickListener{
            tvNumberPlays.setTextColor(getColor(R.color.spotify_green))
            return@setOnLongClickListener true
        }
    }
}