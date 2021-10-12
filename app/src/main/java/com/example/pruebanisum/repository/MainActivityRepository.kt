package com.example.pruebanisum.repository

import com.example.pruebanisum.db.model.ResponseService
import com.example.pruebanisum.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {
    override fun getAbbreviationR(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        val call = apiInterface.getAbbreviation(textToFind)
        call.enqueue(object : Callback<ArrayList<ResponseService>> {
            override fun onFailure(
                call: Call<ArrayList<ResponseService>>,
                t: Throwable
            ) {
                error(t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<ResponseService>>,
                responseService: Response<ArrayList<ResponseService>>
            ) {
                responseService.body()?.let { response(it) }
            }
        })
    }

    override fun getFullFormsR(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        val call = apiInterface.getFullForms(textToFind)
        call.enqueue(object : Callback<ArrayList<ResponseService>> {
            override fun onFailure(
                call: Call<ArrayList<ResponseService>>,
                t: Throwable
            ) {
                error(t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<ResponseService>>,
                responseService: Response<ArrayList<ResponseService>>
            ) {
                responseService.body()?.let { response(it) }
            }
        })
    }
}