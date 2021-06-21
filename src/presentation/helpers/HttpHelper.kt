package presentation.helpers

import presentation.contracts.HttpResponse

data class Response(override val statusCode: Long, override val body: Any) : HttpResponse

fun ok(data: Any): HttpResponse {
    return Response(200, data)
}
