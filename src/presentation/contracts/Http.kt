package presentation.contracts


interface HttpResponse {
    val statusCode: Long
    val body: Any
}