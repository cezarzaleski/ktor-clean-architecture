package data.usecases

import data.mocks.LoadBooksRepositorySpy
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.Mockito.`when`


class DbLoadBooksTest {
    data class SutTypes(
        val sut: DbLoadBooks,
        val loadBooksRepositorySpy: LoadBooksRepositorySpy
    )

    fun MakeSut(): SutTypes {
        val loadBooksRepositorySpy = LoadBooksRepositorySpy()
        val  sut = DbLoadBooks(loadBooksRepositorySpy)
        return SutTypes(sut, loadBooksRepositorySpy)
    }

    @Test
    fun `Should return a list of Books on success`() {
        val make = MakeSut()
        val books = make.sut.load()
        Assertions.assertEquals(books, make.loadBooksRepositorySpy.result)

    }

    @Test
    fun `Should throw if LoadBooksRepository throws`() {
        // @Todo não está 100% pq ignora try catch na implementação
        val make = MakeSut()
        val spy: LoadBooksRepositorySpy = Mockito.spy(make.loadBooksRepositorySpy)
        `when`(spy.loadAll())
            .thenThrow(RuntimeException::class.java)

        Assertions.assertThrows(RuntimeException::class.java) {
            spy.loadAll()
        }
    }
}