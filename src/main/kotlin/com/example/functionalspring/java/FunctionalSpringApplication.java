package com.example.functionalspring.java;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
	* @author <a href="mailto:josh@joshlong.com">Josh Long</a>
	*/
@SpringBootApplication
public class FunctionalSpringApplication {

		public static void main(String args[]) {

				new SpringApplicationBuilder()
					.sources(FunctionalSpringApplication.class)
					.initializers(
						(ApplicationContextInitializer<GenericApplicationContext>) ac -> {
								ac.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("starting " + ApplicationRunner.class.getName() + "."));
								ac.registerBean(RouterFunction.class, () -> route(GET("/hi/{name}"), request -> ServerResponse.ok().body(Flux.just("Hello, " + request.pathVariable("name")), String.class)));
						}
					)
					.run(args);
		}
}
