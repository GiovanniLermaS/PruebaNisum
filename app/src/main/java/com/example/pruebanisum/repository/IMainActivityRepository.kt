package com.example.pruebanisum.repository

import com.example.pruebanisum.db.model.ResponseService

interface IMainActivityRepository {

    fun getAbbreviationR(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    )

    fun getFullFormsR(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    )
}