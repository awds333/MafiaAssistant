package com.fedchenko.mafiaassistant.ui.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fedchenko.mafiaassistant.R
import com.fedchenko.mafiaassistant.ui.view.fragment.StateChangeTimerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transition = supportFragmentManager.beginTransaction()
        transition.add(R.id.bottomContainerFrameLayout,StateChangeTimerFragment())
        transition.commit()
    }
}