package infra.db

import com.example.data.BookEntity
import com.example.domain.entities.Book
import data.contracts.db.book.LoadBooksRepository
import org.jetbrains.exposed.sql.transactions.transaction

class BookDbRepository: LoadBooksRepository {

    override fun loadAll(): Iterable<Book> = transaction {
        BookEntity.all().map(BookEntity::toBook)
    }
}