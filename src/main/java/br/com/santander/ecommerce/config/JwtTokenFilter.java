package br.com.santander.ecommerce.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.santander.ecommerce.model.Usuario;
import br.com.santander.ecommerce.service.UsuarioService;

public class JwtTokenFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final UsuarioService usuarioService;

	public JwtTokenFilter(TokenService tokenService,UsuarioService usuarioService) {
		this.tokenService = tokenService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperaToken(request);
		if (tokenService.isValido(token)) {
			autorizaUsuario(token);
		}
		filterChain.doFilter(request, response);
	}

	private String recuperaToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7);
	}
	
	private void autorizaUsuario(String token) {
		Integer id = tokenService.pegarIdUsuario(token);
		Usuario usuario = usuarioService.buscarPorId(id);
	Authentication authentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
	SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
