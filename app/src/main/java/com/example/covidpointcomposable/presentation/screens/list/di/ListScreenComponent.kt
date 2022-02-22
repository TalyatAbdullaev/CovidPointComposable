package com.example.covidpointcomposable.presentation.screens.list.di

import com.example.covidpointcomposable.di.AppComponent
import com.example.covidpointcomposable.presentation.screens.list.ListViewModel
import dagger.Component
import dagger.Subcomponent

@Subcomponent(
    modules = [ListScreenModule::class],
)
@ListScreenScope
interface ListScreenComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ListScreenComponent
    }

    fun getViewModel() : ListViewModel
}