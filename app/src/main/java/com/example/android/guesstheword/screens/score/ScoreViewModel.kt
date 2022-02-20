package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int): ViewModel() {
    val score: LiveData<Int> = MutableLiveData<Int>()
    val eventPlayAgain: LiveData<Boolean> = MutableLiveData<Boolean>()

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        setScore(finalScore);
        setEventPlayAgain(false);
    }

    fun getScoreValue(): Int {
        return score.value ?: 0;
    }

    private fun setScore(value: Int) {
        (score as MutableLiveData<Int>).value = value
    }

    private fun setEventPlayAgain(value: Boolean) {
        (eventPlayAgain as MutableLiveData<Boolean>).value = value
    }

    fun onPlayAgainComplete() {
        setEventPlayAgain(false)
    }

    fun navigateToPlayAgain() {
        setEventPlayAgain(true);
    }

}