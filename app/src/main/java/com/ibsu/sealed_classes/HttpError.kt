package com.ibsu.sealed_classes


sealed class HttpError(val code: Int, val message: String?) {
    // 4xx Client Errors
    sealed class ClientRequestError(code: Int, message: String?) : HttpError(code, message) {
        class BadRequest(message: String?) : ClientRequestError(400, message)
        class Unauthorized(message: String?) : ClientRequestError(401, message)
        class Forbidden(message: String?) : ClientRequestError(403, message)
        class NotFound(message: String?) : ClientRequestError(404, message)
        class UnknownClientRequestError(code: Int, message: String?) : ClientRequestError(code, message)

    }

    // 5xx Server Errors
    sealed class ServerResponseError(code: Int, message: String?) : HttpError(code, message) {
        class InternalServerError(message: String?) : ServerResponseError(500, message)
        class BadGateway(message: String?) : ServerResponseError(502, message)
        class ServiceUnavailable(message: String?) : ServerResponseError(503, message)
        class UnknownServerResponseError(code: Int, message: String?) : ServerResponseError(code, message)
    }

    class Redirect(code: Int, val location: String?) : HttpError(code, message = null)
}


