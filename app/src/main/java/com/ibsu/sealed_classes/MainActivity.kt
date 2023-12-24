package com.ibsu.sealed_classes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HttpError.ServerResponseException(500)
        val httpError: HttpError =  HttpError.ClientRequestException.NotFound()

//      //exhaustive when
        when(httpError){
            is HttpError.ClientRequestException.NotFound -> {}
            is HttpError.ClientRequestException.Unauthorized -> {}
            is HttpError.RedirectResponseException -> {}
            is HttpError.ServerResponseException -> {}
        }
    }


}