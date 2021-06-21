package com.example.data

import com.example.domain.entities.Book
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Books : IntIdTable() {
    val title = varchar("title", 255)
    val author = varchar("author", 255)
}

class BookEntity(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(Books)

    var title by Books.title;
    var author by Books.author;

    override fun toString() = "Book($title, $author)"

    fun toBook() = Book(id.value, title, author)
}