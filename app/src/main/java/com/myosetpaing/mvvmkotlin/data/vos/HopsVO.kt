package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName

data class HopsVO(
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: VolumeVO,
    @SerializedName("add")
    val add: String,
    @SerializedName("attribute")
    val attribute: String

)
