package main.adapters

import io.ktor.application.*
import io.ktor.response.*
import presentation.contracts.Controller

suspend fun adaptRoute(call: ApplicationCall, controller: Controller) {
    val teste = controller.handle(call.request)
    call.respond(teste.body)
}