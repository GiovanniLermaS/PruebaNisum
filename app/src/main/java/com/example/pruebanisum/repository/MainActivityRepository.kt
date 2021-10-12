package com.example.pruebanisum.repository

import com.example.pruebanisum.db.model.ResponseService
import com.example.pruebanisum.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {
    override fun getResponseR(
        response: (ResponseService?) -> Unit,
        error: (String?) -> Unit
    ) {
        val call = apiInterface.getAbbreviation("HMM")
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
                //response(responseService.body() as ArrayList<ResponseService>)
                responseService.body()
            }
        })
    }
}