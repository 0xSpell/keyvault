package com.example.keyvault

import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class PropsController(
  @Value("\${example.property}")
  val config: String,
  @Value("\${testkey}")
  val secondary: String?,
) {



  @Get("/")
  fun doGet() = Response(config, secondary)
}

data class Response(
  val name: String,
  val secondary: String?
)
