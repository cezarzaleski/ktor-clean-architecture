package main.factories

import data.usecases.DbLoadBooks
import infra.db.BookDbRepository


fun makeDbLoadBooks(): DbLoadBooks {
    return DbLoadBooks(BookDbRepository())
}