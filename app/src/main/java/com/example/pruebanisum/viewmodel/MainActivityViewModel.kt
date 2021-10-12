package com.example.pruebanisum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pruebanisum.db.model.ResponseService
import com.example.pruebanisum.repository.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    fun getResponseV(
        response: (ResponseService?) -> Unit,
        error: (String?) -> Unit
    ) {
        mainActivityRepository.getResponseR({ response(it) }, { error(it) })
    }
}