package com.ciw.backend;

import com.ciw.backend.repository.FeatureRepository;
import com.ciw.backend.repository.UnitRepository;
import com.ciw.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	private final UserRepository userRepository;
	private final UnitRepository unitRepository;
	private final FeatureRepository featureRepository;
	private final PasswordEncoder passwordEncoder;
}