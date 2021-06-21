package data.mocks

import com.example.domain.entities.Book
import data.contracts.db.book.LoadBooksRepository
import domain.mocks.MockBooks

class LoadBooksRepositorySpy: LoadBooksRepository {

    val result = MockBooks()
    override fun loadAll(): Iterable<Book> {
        return MockBooks();
    }
}