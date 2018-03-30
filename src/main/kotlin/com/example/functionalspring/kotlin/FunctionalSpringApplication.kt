package com.example.functionalspring.kotlin

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux

@SpringBootApplication
class FunctionalSpringApplication

fun main(args: Array<String>) {
	SpringApplicationBuilder()
			.sources(FunctionalSpringApplication::class.java)
			.initializers(beans {
				bean {
					ApplicationRunner {
						println("starting ${javaClass.name}...")
					}
				}
				bean {
					router {
						GET("/hi/{name}") {
							ServerResponse.ok().body(Flux.just("Hello, ${it.pathVariable("name")}"))
						}
					}
				}
			})
			.run(*args)

}
