package com.dtg.DummyAuthorizationServer;

import com.dtg.DummyAuthorizationServer.models.User;
import com.dtg.DummyAuthorizationServer.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

@SpringBootApplication
public class DummyAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyAuthorizationServerApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(UserRepository userRepo, PasswordEncoder encoder, InMemoryRegisteredClientRepository inMemory){
		return args -> {
			userRepo.save(
					new User("giangdt", encoder.encode("password"), "ROLE_ADMIN")
			);
			userRepo.save(
					new User("tacochef", encoder.encode("password"), "ROLE_ADMIN")
			);

			RegisteredClient test = inMemory.findByClientId("taco-giangdt");
			System.out.println("logginggggg: " + test.getClientSecret());

		};
	}
}
