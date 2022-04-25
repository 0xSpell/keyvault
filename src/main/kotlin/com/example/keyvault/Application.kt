package com.example.keyvault

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.example.keyvault")
		.start()
}

