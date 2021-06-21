package com.example.routes

import com.example.domain.entities.Book
import com.example.services.BookService
import io.ktor.application.call
import io.ktor.features.NotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import main.adapters.adaptRoute
import main.factories.controllers.makeLoadBooksController
import org.kodein.di.instance
import org.kodein.di.ktor.di


fun Route.books() {

    val bookService by di().instance<BookService>()

    get("books") {
        val httpResponse = makeLoadBooksController().handle(call.request);
        if (compareValues(httpResponse.statusCode, 200L) >= 0 && compareValues(httpResponse.statusCode, 299L) <=0) {
            call.response.status(HttpStatusCode.Accepted)
            call.respond(httpResponse.body)
        } else {
            // @todo mapera possíveis status code
            call.response.status(HttpStatusCode.BadRequest)
            call.respond(httpResponse.body)
        }
    }

//    get("books") {
//        val httpResponse = makeLoadBooksController().handle(call.request);
//        if (httpResponse.statusCode >= 200 && httpResponse.statusCode <= 299) {
//            res.status(httpResponse.statusCode).json(httpResponse.body)
//        } else {
//            res.status(httpResponse.statusCode).json({
//                    error: httpResponse.body.message
//            })
//        }
//
//    }

    post("book") {
        val bookRequest = call.receive<Book>()
        bookService.addBook(bookRequest)
        call.respond(HttpStatusCode.Accepted)
    }

    delete("book/{id}") {
        val bookId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        bookService.deleteBook(bookId)
        call.respond(HttpStatusCode.OK)
    }
}
