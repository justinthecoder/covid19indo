package com.covidindo

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        refresh_layout.isRefreshing = true
        refresh_layout.setOnRefreshListener {
            viewModel.triggerFetchFromBackend()
        }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getCovidDataEvent.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> {
                    refresh_layout.isRefreshing = false
                    content_wrapper.visibility = View.GONE
                    Toast.makeText(
                        this,
                        "Sedang terjadi kesalahan... Data tidak dapat diambil",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Status.LOADING -> {
                    content_wrapper.visibility = View.GONE
                    refresh_layout.isRefreshing = true
                }
                Status.SUCCESS -> {
                    content_wrapper.visibility = View.VISIBLE
                    refresh_layout.isRefreshing = false
                    it.data?.let { result ->
                        textView1.text = "Total Kasus: ${resul  t.totalcases.toString()}"
                        textView2.text = "Total Meninggal: ${result.confirmedDead.toString()}"
                        textView3.text = "Total Sembuh: ${result.confirmedHealed.toString()}"
                    }
                }
            }
        })
    }
}
