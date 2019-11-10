package com.example.newsanchor.models

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */

data class TransactionHistoryModel (
    val user: String,
    val amount: String,
    val amountType: String,
    val transactionType: String,
    val date: String,
    val description: String,
    val userImage: String,
    var isExpanded: Boolean = false
)