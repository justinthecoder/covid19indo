package com.covidindo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.covidindo.util.Status
import com.covidindo.viewModel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
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
                    it.data?.let { result ->
                        textView1.text = "Total Cases: ${result.totalcases.toString()}"
                        textView2.text = "Confirmed Death : ${result.confirmedDead.toString()}"
                        textView3.text = "Confirmed Healed : ${result.confirmedHealed.toString()}"
                    }
                }
            }
        })
    }
}
