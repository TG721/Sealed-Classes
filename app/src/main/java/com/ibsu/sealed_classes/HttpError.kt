package com.ibsu.sealed_classes


//Declaring child classes inside the sealed parent class (or in the same file) is a common/good practice
//but not mandatory

sealed class HttpError(val code: Int) {
    class RedirectResponseException(code: Int) : HttpError(code)
    sealed class ClientRequestException(code: Int) : HttpError(code){
        class Unauthorized: HttpError(401)
        class NotFound: HttpError(404)
    }
    class ServerResponseException(code: Int) : HttpError(code)
}

