package com.example.newweatherapp.contracts

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.newweatherapp.R
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode

class PlaceContract: ActivityResultContract<Intent, Intent?>() {
    override fun createIntent(context: Context, input: Intent?): Intent {
        if (!Places.isInitialized()) {
            Places.initialize(context, context.getString(R.string.places_api_key))
        }

        Places.createClient(context)
        val fields = listOf(Place.Field.ID, Place.Field.NAME)
        return Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields).build(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Intent? {
            
    }

}
