package com.example.newweatherapp.models.location_images

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Typeahead_autocomplete")
    val dataSubClass: TypeaheadAutocomplete
    )

