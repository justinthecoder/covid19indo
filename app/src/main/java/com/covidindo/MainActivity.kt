package com.covidindo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.covidindo.viewModel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*
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
        viewModel.getData().observe(this, Observer {
            if (it != null) {
                val a = it
                textView1.text = "Total Cases: ${it.totalcases.toString()}"
                textView2.text = "Confirmed Death : ${it.confirmedDead.toString()}"
                textView3.text = "Confirmed Healed : ${it.confirmedHealed.toString()}"
            }
        })
    }
}
