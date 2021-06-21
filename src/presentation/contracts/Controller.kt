package presentation.contracts


interface Controller {
    fun handle(request: Any): HttpResponse
}