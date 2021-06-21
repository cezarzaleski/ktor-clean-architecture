package data.usecases

import com.nhaarman.mockitokotlin2.doThrow
import data.mocks.LoadBooksRepositorySpy
import org.junit.Test
import org.mockito.Mockito
import kotlin.test.assertEquals


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
        assertEquals(books, make.loadBooksRepositorySpy.result)

    }

    @Test
    fun `Should throw if LoadBooksRepository throws`() {
        val make = MakeSut()
        val loadBooksRepositorySpy = Mockito.spy(make.loadBooksRepositorySpy)
        Mockito.doThrow(Exception("yay!")).`when`(loadBooksRepositorySpy.loadAll())
        doThrow(Exception("yay!")).`when`(loadBooksRepositorySpy).loadAll()


    }
}