package com.covidindo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.covidindo.util.Status
import com.covidindo.viewModel.DataViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: DataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.triggerFetchFromBackend()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getCovidDataEvent.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> {
                    //TODO: Show error message
                }
                Status.LOADING -> {
                    //TODO: Show progress bar
                }
                Status.SUCCESS -> {
                    it.data?.let {
                        //TODO: Show UI here
                    }
                }
            }
        })
    }
}
