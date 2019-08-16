package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName

data class MaltVO(
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: VolumeVO
)




