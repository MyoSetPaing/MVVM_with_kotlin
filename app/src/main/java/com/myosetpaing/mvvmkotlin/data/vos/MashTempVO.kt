package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName

data class MashTempVO(
    @SerializedName("temp")
    val temp: VolumeVO,

    @SerializedName("duration")
    val duration: Int

)
