package com.example.pruebanisum.repository

import com.example.pruebanisum.db.model.Lf
import com.example.pruebanisum.db.model.ResponseService

class FakeMainActivityRepository : IMainActivityRepository {
    override fun getAbbreviationR(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        setResponse(response, error)
    }

    override fun getFullFormsR(
        textToFind: String?,
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        setResponse(response, error)
    }

    private fun setResponse(
        response: (ArrayList<ResponseService>) -> Unit,
        error: (String?) -> Unit
    ) {
        val responseArrayList = ArrayList<ResponseService>()
        val responseService1 = ResponseService()
        val listLf = ArrayList<Lf>()
        val lf1 = Lf()
        lf1.since = 1993
        lf1.freq = 123
        lf1.lf = "sasdasd"
        listLf.add(lf1)
        val lf2 = Lf()
        lf2.since = 1996
        lf2.freq = 1545
        lf2.lf = "sasdasd"
        listLf.add(lf2)
        val lf3 = Lf()
        lf3.since = 1991
        lf3.freq = 15663
        lf3.lf = "sasdasd"
        listLf.add(lf3)
        responseService1.lfs = listLf
        responseArrayList.add(responseService1)
        if (responseArrayList.isNotEmpty()) {
            response(responseArrayList)
        } else {
            error("Error")
        }
    }
}