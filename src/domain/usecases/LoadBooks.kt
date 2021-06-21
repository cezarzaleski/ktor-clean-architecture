package domain.usecases

import com.example.domain.entities.Book

interface LoadBooks {
    fun load(): Iterable<Book>
}