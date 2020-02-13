package com.fedchenko.mafiaassistant.model.statemachine

interface State {
    fun init()
    fun finish()
}