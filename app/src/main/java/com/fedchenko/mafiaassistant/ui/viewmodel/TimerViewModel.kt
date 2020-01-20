package com.fedchenko.mafiaassistant.ui.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {
    private val timerSecondsLiveData: MutableLiveData<String> = MutableLiveData("1:00")
    val timerSeconds: LiveData<String> = timerSecondsLiveData
    private val isRunningLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val isRunning: LiveData<Boolean> = isRunningLiveData
    private val isPausedLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val isPaused: LiveData<Boolean> = isPausedLiveData
    private val isLessThenTenSecondsLeftLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLessThenTenSecondsLeft: LiveData<Boolean> = isLessThenTenSecondsLeftLiveData

    private var pauseTime = 0L
    var startTime = 60L

    private lateinit var countDownTimer: CountDownTimer

    fun reset() {
        isLessThenTenSecondsLeftLiveData.value = false
        isPausedLiveData.value = false
        if (isRunningLiveData.value == true) {
            isRunningLiveData.value = false
            countDownTimer.cancel()
        }

        val minutes = startTime / 60
        val seconds = startTime % 60
        timerSecondsLiveData.value = String.format("%d:%02d", minutes, seconds)
    }

    fun pause() {
        isLessThenTenSecondsLeftLiveData.value = false
        isPausedLiveData.value = true
        if (isRunningLiveData.value == true) {
            isRunningLiveData.value = false
            countDownTimer.cancel()
        }
    }

    fun start() {
        if (isRunningLiveData.value == true)
            return
        if (isPausedLiveData.value == true)
            run(pauseTime)
        else
            run(startTime)
    }

    private fun run(time: Long) {
        countDownTimer = object : CountDownTimer(1000 * time, 1000) {
            override fun onFinish() {
                isRunningLiveData.value = false
                isLessThenTenSecondsLeftLiveData.value = false
            }

            override fun onTick(millisUntilFinished: Long) {
                pauseTime = millisUntilFinished / 1000
                isLessThenTenSecondsLeftLiveData.value = pauseTime <= 10

                val minutes = millisUntilFinished / 1000 / 60
                val seconds = millisUntilFinished / 1000 % 60
                timerSecondsLiveData.value = String.format("%d:%02d", minutes, seconds)
            }

        }
        isRunningLiveData.value = true
        isPausedLiveData.value = false
        countDownTimer.start()
    }

    override fun onCleared() {
        super.onCleared()
        if (isRunningLiveData.value == true)
            countDownTimer.cancel()
    }
}