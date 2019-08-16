package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName

data class MethodVO(

    @SerializedName("mash_temp")
    val mash_temp: List<MashTempVO>,

    @SerializedName("fermentation")
    val fermentation: FermentationVO,

    @SerializedName("twist")
    val twist: String?

)
