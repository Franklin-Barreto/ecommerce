package br.com.santander.ecommerce.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsPasswordService {

	
	
	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
