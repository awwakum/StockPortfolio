package com.awwakum.android.stockportfolio.models

import com.awwakum.android.stockportfolio.BR
import com.awwakum.android.stockportfolio.R

data class Stock(val title: String, val value: String) {
    val brVariableId = BR.stock
    val layoutId = R.layout.item_stock
}