package com.bridgelabz.UserManagement.Utility;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.UserManagement.exception.InvalideToken;
import com.bridgelabz.UserManagement.message.MessageInfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {
	@Autowired
	MessageInfo message;

	SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;

	static String secretKey = "iamsecretkey";

	public String generateToken(String userName) {
		return Jwts.builder().setId(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(algorithm, secretKey).compact();
	}

	public String getToken(String token) {
		Claims claim = null;
		try {
			claim = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			throw new InvalideToken(message.Invalide_Token);
		}
		return claim.getId();
	}
}
