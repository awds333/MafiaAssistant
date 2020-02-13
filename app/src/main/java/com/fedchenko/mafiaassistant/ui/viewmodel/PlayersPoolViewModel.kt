package com.fedchenko.mafiaassistant.ui.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.fedchenko.mafiaassistant.model.Player

class PlayersPoolViewModel : ViewModel() {
    private val playersLifeData: MutableLiveData<List<Player>> = MutableLiveData(emptyList())

    fun observePlayers(observer: Observer<List<Player>>, lifecycleOwner: LifecycleOwner) {
        playersLifeData.observe(lifecycleOwner, observer)
    }
}