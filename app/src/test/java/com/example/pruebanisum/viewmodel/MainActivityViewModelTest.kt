package com.example.pruebanisum.viewmodel

import com.example.pruebanisum.repository.FakeMainActivityRepository
import org.junit.Before
import org.junit.Test

class MainActivityViewModelTest {

    private lateinit var viewModel: MainActivityViewModel

    @Before
    fun setUp() {
        viewModel = MainActivityViewModel(FakeMainActivityRepository())
    }

    @Test
    fun consumeAnyService() {
        viewModel.getAbbreviationV("fd", { listResponseService ->
            println("Lf: ${listResponseService[0].lfs[0].lf}")
            println("Since: ${listResponseService[0].lfs[0].since}")
            println("Freq: ${listResponseService[0].lfs[0].freq}")
        }, { error ->
            println("Error: $error")
        })
    }
}