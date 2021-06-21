package data.usecases

import com.example.domain.entities.Book
import data.contracts.db.book.LoadBooksRepository
import domain.usecases.LoadBooks

class DbLoadBooks(private val loadBooksRepository: LoadBooksRepository): LoadBooks {


    override fun load(): Iterable<Book> {
        return loadBooksRepository.loadAll()
    }
}