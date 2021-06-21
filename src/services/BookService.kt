package com.example.services

import com.example.data.BookEntity
import com.example.domain.entities.Book
import org.jetbrains.exposed.sql.transactions.transaction

class BookService {

    fun getAllBooks(): Iterable<Book> = transaction {
        BookEntity.all().map(BookEntity::toBook)
    }

    fun addBook(book: Book) = transaction {
        BookEntity.new {
            this.title = book.title
            this.author = book.author
        }
    }

    fun deleteBook(bookId: Int) = transaction {
        BookEntity[bookId].delete()
    }
}