package com.example.ztelocker.model

data class RetailerResponse (
    var msg:String,
    var status:Boolean,
    private var  retailer: Retailer)
