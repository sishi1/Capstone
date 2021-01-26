package com.example.capstone.model

import com.google.gson.annotations.SerializedName

class Player (
    @SerializedName("platform")
    var platform: String? = null,
    @SerializedName("name")
    var name: String? = null
        )