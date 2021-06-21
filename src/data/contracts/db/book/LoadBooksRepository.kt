package data.contracts.db.book

import com.example.domain.entities.Book

interface LoadBooksRepository {
    fun loadAll(): Iterable<Book>
}