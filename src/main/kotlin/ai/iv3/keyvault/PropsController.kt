package ai.iv3.keyvault

import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class PropsController(
  @Value("\${iv3.property}")
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
