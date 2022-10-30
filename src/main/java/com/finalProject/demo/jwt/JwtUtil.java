package com.finalProject.demo.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtUtil {

    public   static final long EXPIRE = 1000*60*60;//有效期限1hr
    public static final String TOKEN_SECRET = "chezmoi";

    public static String getJwtToken(String email,String name){

        byte[] key = Decoders.BASE64.decode((TOKEN_SECRET));
        SecretKey secretKey = Keys.hmacShaKeyFor(key);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")//標頭
                .setHeaderParam("alg","HS256")
                .setSubject("token")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .claim("email",email)
                .claim("name",name).signWith(secretKey,SignatureAlgorithm.HS256)
                .compact();
    }

}
