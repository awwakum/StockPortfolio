package com.awwakum.android.stockportfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.awwakum.android.stockportfolio.models.Stock
import com.github.ajalt.timberkt.Timber
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        val adapter = StockListAdapter { stock : Stock -> stockClicked(stock)}

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        adapter.add(Stock("AAPL", "340.32"))
        adapter.add(Stock("LRCX", "570.89"))

    }

    private fun stockClicked(partItem : Stock) {
        Toast.makeText(this, "Clicked: ${partItem.title}", Toast.LENGTH_LONG).show()
    }
}
