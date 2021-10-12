package com.example.pruebanisum.retrofit

import com.example.pruebanisum.db.model.ResponseService
import com.example.pruebanisum.utils.BASE_URL
import com.example.pruebanisum.utils.LF
import com.example.pruebanisum.utils.SF
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(BASE_URL)
    fun getAbbreviation(@Query(SF) sf: String): Call<ArrayList<ResponseService>>

    @GET(BASE_URL)
    fun getFullForms(@Query(LF) lf: String): Call<ArrayList<ResponseService>>
}