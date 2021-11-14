package com.appartementlocation.projet.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.appartementlocation.projet.services.JwtService;
import com.appartementlocation.projet.utils.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{


	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String header=request.getHeader("Authorization");
		String jwtToken=null;
		String username=null;
		if(header!=null && header.startsWith("Bearer ")) {
			jwtToken=header.substring(7);
			
			
			try {
				username=jwtUtil.getUserNameFromToken(jwtToken);
				
			} catch (IllegalArgumentException e) {
				// TODO: handle exception
				System.out.print("Uneable to get jwt token");
				
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
				System.out.print("jwt token is expired");
			}
		}else {
			System.out.print("jwt token doesnt start with bearer");
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails= jwtService.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
		filterChain.doFilter(request, response);
		
	}
	

}
