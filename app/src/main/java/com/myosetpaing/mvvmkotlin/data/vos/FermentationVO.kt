package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName

data class FermentationVO(
    @SerializedName("temp")
    val temp: VolumeVO
)
