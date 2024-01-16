package com.tech.ztelocker.model

import com.google.gson.annotations.SerializedName

data class QRCodeCreateRequest(
    @SerializedName("data")
    val `data`: String,

)