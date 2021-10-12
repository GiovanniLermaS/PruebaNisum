package com.example.pruebanisum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pruebanisum.db.model.ResponseService
import com.example.pruebanisum.repository.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    fun getAbbreviationV(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        mainActivityRepository.getAbbreviationR(textToFind, { response(it) }, { error(it) })
    }

    fun getFullFormsV(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        mainActivityRepository.getFullFormsR(textToFind, { response(it) }, { error(it) })
    }
}