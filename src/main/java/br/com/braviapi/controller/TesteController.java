package br.com.braviapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
public class TesteController {

	@GetMapping()
	public ResponseEntity<String> findTask() {
		try {
			
			
			return ResponseEntity.ok().body("CHEGUEI VIADO");
		} catch (RuntimeException e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} 
	}
}
