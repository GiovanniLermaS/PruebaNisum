package com.example.pruebanisum.view.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebanisum.databinding.ActivityMainBinding
import com.example.pruebanisum.view.adapter.VarsAdapter
import com.example.pruebanisum.viewmodel.MainActivityViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TextWatcher {

    private val homeActivityViewModel by viewModels<MainActivityViewModel>()

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.etTextToFind?.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //No implementation needed
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        consumeGetAbbreviation(binding?.etTextToFind?.text?.toString())
    }

    override fun afterTextChanged(s: Editable?) {
        //No implementation needed
    }

    private fun consumeGetAbbreviation(textToFind: String?) {
        homeActivityViewModel.getAbbreviationV(
            textToFind,
            { responseService ->
                if (responseService.isEmpty())
                    consumeGetFullForms(textToFind)
                else binding?.rvVars?.adapter = VarsAdapter(responseService[0].lfs)
            },
            { error ->
                Snackbar.make(binding?.clMain!!, "$error", Snackbar.LENGTH_SHORT).show()
            })
    }

    private fun consumeGetFullForms(textToFind: String?) {
        homeActivityViewModel.getFullFormsV(
            textToFind,
            { responseService ->
                if (responseService.isNotEmpty())
                    binding?.rvVars?.adapter = VarsAdapter(responseService[0].lfs)
            },
            { error ->
                Snackbar.make(binding?.clMain!!, "$error", Snackbar.LENGTH_SHORT).show()
            })
    }
}