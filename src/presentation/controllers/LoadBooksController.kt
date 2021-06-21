package presentation.controllers

import domain.usecases.LoadBooks
import presentation.contracts.Controller
import presentation.contracts.HttpResponse
import presentation.helpers.ok

class LoadBooksController(private val loadBooks: LoadBooks): Controller {
    override fun handle(request: Any): HttpResponse {
        val books = loadBooks.load()
        return ok(books)
    }
}