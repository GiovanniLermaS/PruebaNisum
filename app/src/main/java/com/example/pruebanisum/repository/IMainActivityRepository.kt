package com.example.pruebanisum.repository

import com.example.pruebanisum.db.model.ResponseService

interface IMainActivityRepository {

    fun getResponseR(
        response: (ResponseService?) -> Unit,
        error: (String?) -> Unit
    )
}