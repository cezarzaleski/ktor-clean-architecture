package main.factories.controllers

import main.factories.makeDbLoadBooks
import presentation.controllers.LoadBooksController

fun makeLoadBooksController(): LoadBooksController {
    return LoadBooksController(makeDbLoadBooks())
}