package com.trimbell.vexstats.services.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    /*
    This is the part of the URL that never changes
    It is a constant value, and its name is in all caps to signify that.
    */
    val BASE_URL = "https://api.vexdb.io/"

    // This private variable is where the actual RetroFit is located
    // It is a singleton and its name is in all caps to signify that.
    private var INSTANCE: Retrofit? = null
    // This is the value used to give access to the single RetroFit instance
    val retrofit: Retrofit
        // Custom get works similar to the custom set in our ViewHolder.
        get() {
            // If INSTANCE is null, create a new one.
            return INSTANCE ?: Retrofit.Builder()
                        // Sets the URL
                        .baseUrl(BASE_URL)
                        // Tells RetroFit that we will be getting JSON and would like to
                        // convert it to Kotlin objects using the GSON converter library.
                        .addConverterFactory(GsonConverterFactory.create())
                        // Finally builds our RetroFit and assigns it to INSTANCE
                        .build().also { INSTANCE = it }

            // Since our custom getter sets a value to INSTANCE if it is null,
            // we can be 100% confident that when we reach this return line,
            // INSTANCE will no longer be null, and that is the reason for the
            // double '!'.  Try removing them to see what happens if you'd like.
        }
}

