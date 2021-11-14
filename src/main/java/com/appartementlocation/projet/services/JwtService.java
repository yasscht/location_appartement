package com.appartementlocation.projet.services;
import com.appartementlocation.projet.models.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.JwtRequest;
import com.appartementlocation.projet.models.JwtResponse;
import com.appartementlocation.projet.repository.UserRepository;
import com.appartementlocation.projet.utils.JwtUtil;

@Service
public class JwtService implements UserDetailsService {

	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
		String username=jwtRequest.getUsername();
		String password=jwtRequest.getPassword();
		authenticate(username, password);
		final UserDetails userDetails=loadUserByUsername(username);
		String newGenereatedToken=jwtUtil.generateToken(userDetails);
		User user=userRepository.findById(username).get();
		return new JwtResponse(user,newGenereatedToken);
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= userRepository.findById(username).get();
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(
					user.getEmail(),user.getPassword(),(Collection<? extends GrantedAuthority>) getAuthorities(user)
					);
			
		}else {
			throw new UsernameNotFoundException("Email or username not found");
		}
		
		
	}
	
	private Set<Object> getAuthorities(User user) {
		Set<Object> authorities = new HashSet<>();
		user.getRole().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE"+role.getRoleName()));
		});
		return authorities;
	}
	
private void authenticate(String username,String password) throws Exception{
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
		throw new Exception("User diseabled");
	} catch (BadCredentialsException e) {
		throw new Exception("Bad Credentiels");
	}

}
}
