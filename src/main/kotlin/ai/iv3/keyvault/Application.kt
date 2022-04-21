package ai.iv3.keyvault

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("ai.iv3.keyvault")
		.start()
}

