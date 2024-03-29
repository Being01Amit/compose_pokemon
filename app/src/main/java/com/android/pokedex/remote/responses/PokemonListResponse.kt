package com.android.pokedex.remote.responses
import com.google.gson.annotations.SerializedName


data class PokemonListResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<Result>
)

data class Result(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)