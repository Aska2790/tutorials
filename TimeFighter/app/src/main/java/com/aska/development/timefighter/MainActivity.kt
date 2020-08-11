package com.aska.development.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //region Fields

    private val initialCountDown: Long = 60000
    private val countDownInterval: Long = 1000
    private var timeLeftOnTimer: Long = initialCountDown

    private var score: Int = 0
    private var gameStarted: Boolean = false

    private lateinit var tapMeButton: Button
    private lateinit var timeLeftTextView: TextView
    private lateinit var gameScoreTextView: TextView

    private lateinit var countDownTimer: CountDownTimer

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tapMeButton)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
        timeLeftTextView = findViewById(R.id.timeLeftTextView)

        tapMeButton.setOnClickListener { _ ->
            incrementScore()
        }

        gameScoreTextView.text = getString(R.string.yourScore, score)

        if(savedInstanceState != null){
            score = savedInstanceState.getInt(SCORE_KEY)
            timeLeftOnTimer = savedInstanceState.getLong(TIME_LEFT_KEY)
            restoreGame()
        }else{
            resetGame()
        }

        Log.d(TAG, "onCreate: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_KEY, score)
        outState.putLong(TIME_LEFT_KEY, timeLeftOnTimer)
        countDownTimer.cancel()

        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    //endregion

    //region Action

    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }

        score += 1
        val newScore = getString(R.string.yourScore, score)
        gameScoreTextView.text = newScore
    }

    private fun restoreGame() {
        gameScoreTextView.text =  getString(R.string.yourScore, score)
        timeLeftTextView.text =  getString(R.string.timeLeft, timeLeftOnTimer/countDownInterval)

        countDownTimer = object : CountDownTimer(timeLeftOnTimer, countDownInterval){
            override fun onFinish() {
                endGame()
            }

            override fun onTick(millisUntilFinished: Long) {
                timeLeftOnTimer = millisUntilFinished;
                val timeLeft = millisUntilFinished / countDownInterval
                timeLeftTextView.text = getString(R.string.timeLeft, timeLeft)
            }
        }
        gameStarted = true
        countDownTimer.start()
    }


    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.yourScore, score)

        val initialTimeLeft = initialCountDown / countDownInterval;
        timeLeftTextView.text = getString(R.string.timeLeft, initialTimeLeft)

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftOnTimer = millisUntilFinished;
                val timeLeft = millisUntilFinished / countDownInterval
                timeLeftTextView.text = getString(R.string.timeLeft, timeLeft)
            }

            override fun onFinish() {
                endGame()
            }
        }

        gameStarted = false

    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.gameOverMessage, score), Toast.LENGTH_LONG).show()
        resetGame()
    }

    //endregion

    //region Inner

    companion object {
        private val TAG = MainActivity::class.simpleName
        private const val SCORE_KEY = "SCORE_KEY"
        private const val TIME_LEFT_KEY = "TIME_LEFT_KEY"
    }

    //endregion
}
