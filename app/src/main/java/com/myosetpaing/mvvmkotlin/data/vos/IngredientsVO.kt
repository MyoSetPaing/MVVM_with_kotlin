package com.myosetpaing.mvvmkotlin.data.vos

import com.google.gson.annotations.SerializedName

data class IngredientsVO(

    @SerializedName("malt")
    val malt: List<MaltVO>,

    @SerializedName("hops")
    val hops: List<HopsVO>,

    @SerializedName("yeast")
    val yeast: String

)
