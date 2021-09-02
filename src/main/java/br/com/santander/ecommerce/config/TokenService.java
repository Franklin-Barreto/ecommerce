package br.com.santander.ecommerce.config;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.santander.ecommerce.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	private String chave = "$TQ(TQ$RQ)K(RQGKQAGFW";
	private Integer expiracao = 1800000;

	public String geraToken(Authentication authenticate) {
		Usuario usuario = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date DataExpiracao = new Date(hoje.getTime() + expiracao);
		return Jwts.builder()
				.setSubject(usuario.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(DataExpiracao)
				.signWith(SignatureAlgorithm.HS512, chave)
				.compact();
	}

}
