package com.fedchenko.mafiaassistant.di

import com.fedchenko.mafiaassistant.ui.viewmodel.PlayersPoolViewModel
import com.fedchenko.mafiaassistant.ui.viewmodel.TimerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module{
    viewModel { TimerViewModel() }
    viewModel { PlayersPoolViewModel() }
}