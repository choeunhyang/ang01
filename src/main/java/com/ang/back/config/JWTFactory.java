package com.ang.back.config;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JWTFactory { // 인증서 같은 날짜 제한 토큰
	private static final String TOKEN_KEY = "df.fl.wlq";
	
	public String generateJWT(String id) {
		Calendar cal = Calendar.getInstance();
		Date issueDate = cal.getTime();
		cal.add(Calendar.DATE, 10);
		Date expireDate = cal.getTime();
		
		Builder jwt = JWT.create();
		String token = jwt.withIssuedAt(issueDate)
		.withIssuer(id)
		.withExpiresAt(expireDate)
		.sign(Algorithm.HMAC256(TOKEN_KEY));
		return token;
	}
	
	public boolean verifyJWT(String id,String token) throws Exception {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_KEY)).withIssuer(id).build();
		DecodedJWT jwt = verifier.verify(token);  // HMAC256 은 암호화 방식
		System.out.println(jwt.getExpiresAt());
		return true;
	}
	
	public static void main(String[] args) {
		JWTFactory jf = new JWTFactory();
		//String token = jf.generateJWT("test");
		try {
			//System.out.println(token);
			//System.out.println(jf.verifyJWT("test",token));
			System.out.println(jf.verifyJWT("test","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ0ZXN0IiwiZXhwIjoxNTQ3NDU5NTM0LCJpYXQiOjE1NDY1OTU1MzR9.k6Ap4qJqE1ca-LP9Cvs_EEr6Fmu0CjiKLKSz2sOgyAs"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}
