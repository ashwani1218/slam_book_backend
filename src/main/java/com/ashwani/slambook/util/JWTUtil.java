package com.ashwani.slambook.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.constants.JWTConstants;
import com.ashwani.slambook.entity.User;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	

	@Value("${jjwt.expiration}")
	private String expirationTime;
	
	private Key key;

	byte[] secretKey = Base64.decode(JWTConstants.SECRET);
	
	@PostConstruct
	public void init(){
		this.key = Keys.hmacShaKeyFor(secretKey);
	}

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
	
	public String getUsernameFromToken(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", user.getRoles());
		return doGenerateToken(claims, user.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String username) {
		Long expirationTimeLong = Long.parseLong(expirationTime); //in second
		
		final Date createdDate = new Date();
		final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);

		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(createdDate)
				.setExpiration(expirationDate)
				.signWith(key)
				.compact();
	}
	
	public Boolean validateToken(String token) {
		try{
			Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secretKey)).build().parseClaimsJws(token);
			return true;
		}
		catch(JwtException e) {
			return false;
		}
	}
}
