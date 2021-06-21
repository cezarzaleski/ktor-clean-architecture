package com.example.services

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider
import org.kodein.di.singleton

fun DI.MainBuilder.bindServices(){
    bind<BookService>() with singleton { BookService() }

}