package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName


data class VolumeVO(
    @SerializedName("value")
    val value:Double,

    @SerializedName("unit")
    val unit: String

)