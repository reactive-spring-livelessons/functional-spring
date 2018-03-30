package com.example.functionalspring;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

/**
	* @author <a href="mailto:josh@joshlong.com">Josh Long</a>
	*/
public class JavaMain {
/*		public static void main(String[] args) {

				new SpringApplicationBuilder()
					.sources(FunctionalSpringApplication.class)
					.initializers((ApplicationContextInitializer<GenericApplicationContext>) gac -> {

							gac.registerBean(Foo.class, Foo::new);

							gac.registerBean(Bar.class, () -> {
									Foo foo = gac.getBean(Foo.class);
									return new Bar(foo);
							});

							for (int i = 0; i < 10; i++) {
									gac.registerBean("name" + i, ApplicationRunner.class, indexedRunnner(i));
							}
					})
					.run(args);

		}
		*/

		static class Foo {
		}

		static class Bar {
				private final Foo foo;

				Bar(Foo foo) {
						this.foo = foo;
						System.out.println("got a referencce to " +  this.foo.toString());
				}
		}

		private static Supplier<ApplicationRunner> indexedRunnner(int i) {
				return () -> (ApplicationRunner) args -> System.out.println("hello, " + i);
		}


/*
		@Bean
		ApplicationRunner runner() {
				return args -> System.out.println("hello, world");
		}
*/
}
