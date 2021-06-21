package domain.mocks

import com.example.domain.entities.Book

fun MockBookEntitie(): Book {
    return Book(1, "Titulo", "Autor")
}

fun MockBooks(): Iterable<Book> {
    val arrayList = ArrayList<Book>()
    arrayList.add(MockBookEntitie())
    arrayList.add(MockBookEntitie())
    return arrayList.asIterable();
}
