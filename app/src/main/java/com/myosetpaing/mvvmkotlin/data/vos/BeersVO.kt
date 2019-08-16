package com.myosetpaing.mvvmkotlin.data.vos

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "beer")
class BeersVO {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("first_brewed")
    var first_brewed: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("image_url")
    var image_url: String? = null

    @SerializedName("abv")
    var abv: Double = 0.0

    @SerializedName("ibu")
    var ibu: Double = 0.0

    @SerializedName("target_fg")
    var target_fg: Double = 0.0

    @SerializedName("target_og")
    var target_og: Double = 0.0

    @SerializedName("ebc")
    var ebc: Double = 0.0

    @SerializedName("srm")
    var srm: Double = 0.0

    @SerializedName("ph")
    var ph: Double = 0.0

    @SerializedName("attenuation_level")
    var attenuation_level: Double = 0.0

    @Ignore
    @SerializedName("volume")
    var volume: VolumeVO? = null

    @Ignore
    @SerializedName("boil_volume")
    val boil_volume: VolumeVO? = null

    @Ignore
    @SerializedName("method")
    var method: MethodVO? = null

    @Ignore
    @SerializedName("ingredients")
    var ingredients: IngredientsVO? = null

    @Ignore
    @SerializedName("food_pairing")
    var food_pairing: List<String>? = null

    @SerializedName("brewers_tips")
    var brewers_tips: String? = null

    @SerializedName("contributed_by")
    var contributed_by: String? = null


}