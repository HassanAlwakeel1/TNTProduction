package com.tntproduction;

import com.tntproduction.model.entity.User;
import com.tntproduction.model.entity.enums.Role;
import com.tntproduction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TNTProduction implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TNTProduction.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(adminAccount == null){
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setFirstName("hassan");
			user.setLastName("gamal");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
