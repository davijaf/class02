package com.assurance.class02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

/**
 * Endpoint simples de saúde do servidor.
 * GET /health  ->  200 OK  {"status":"UP","service":"class02","timestamp":"..."}
 */
@RestController
public class HealthController {

	@GetMapping("/health")
	public Map<String, Object> health() {
		return Map.of(
				"status", "UP",
				"service", "class02",
				"timestamp", Instant.now().toString()
		);
	}
}
