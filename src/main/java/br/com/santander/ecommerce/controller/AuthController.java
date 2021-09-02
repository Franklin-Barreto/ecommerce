package br.com.santander.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.config.TokenService;
import br.com.santander.ecommerce.model.dto.FormLogin;
import br.com.santander.ecommerce.model.dto.TokenDto;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager; 
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autentica(@RequestBody FormLogin formLogin){
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(formLogin.getEmail(),formLogin.getSenha());
		Authentication authenticate = authenticationManager.authenticate(authentication);
		String token = tokenService.geraToken(authenticate);
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	}
}
