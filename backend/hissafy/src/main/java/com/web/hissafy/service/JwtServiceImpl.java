package com.web.hissafy.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.hisssafy.dto.ProDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

	@Autowired
	ProServiceImpl pSer;

	private static final String SALT = "hissafy5joSecret";

	private String secretKey = SALT;
	
	private byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);

	private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	private final Key KEY = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	@Override
	public String create(ProDto pro) {
		String jwt = Jwts.builder()
				 .setHeaderParam("typ", "JWT")
				 .setHeaderParam("regDate", System.currentTimeMillis())
				 .setSubject(pro.getUser_id())
				 .claim("nickname", pro.getUser_name())
				 .setExpiration(new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 60 * 24)))
				 .signWith(signatureAlgorithm, KEY)
				 .compact();
return jwt;

	}

	@Override
	public boolean validationToken(String jwt) {
		if(jwt !=null) {
			String user_key = this.getUserId(jwt);
			String user_id = pSer.proInfo(this.getUserId(jwt)).getUser_id();
			if(user_key.equals(user_id)) {
				return true; 
			}else {
				return false; 
			}
		}
		return false;
	}

	@Override
	public boolean getExpToken(String jwt) {
		return false;
	}

	@Override
	public String getUserId(String jwt) {
		try {
			return Jwts.parser()
					.setSigningKey(KEY)
					.parseClaimsJws(jwt)
					.getBody()
					.getSubject();
		}catch (Exception e) {
			return null;
		}
		
	}

//	@Override
//	public String getUserName(String jwt) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUserLocation(String jwt) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
