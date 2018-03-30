package com.example.functionalspring

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

/**
 * @author <a href="mailto:josh@joshlong.com">Josh Long</a>
 */

fun main(args: Array<String>) {

	SpringApplicationBuilder()
			.initializers(beans {

				arrayOf(1, 2, 3, 4).forEach { indx ->
					bean("runner${indx}") {
						ApplicationRunner {
							println("hello $indx")
						}
					}
				}

				if (Math.random() > .5)
					bean {
						ApplicationRunner {
							println("Hello, world!")
						}
					}

				bean {
					Bar()
				}
				bean {
					Foo(ref())
				}

			})
			.sources(FunctionalSpringApplication::class.java)
			.run(*args)

}

class Bar

class Foo(val bar: Bar)
