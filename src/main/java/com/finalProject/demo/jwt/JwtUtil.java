package com.finalProject.demo.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;


@Service
public class JwtUtil {

    public   static final long EXPIRE = 1000*60*60;//有效期限1hr
    public static final String TOKEN_SECRET = "####HEYTHEREWELCOMETOCHEZMOIWebtheBestallfromkorea####";//私鑰保存在Server

    /**
     *
     * @param email
     * @param name
     * @return
     */
    public static String getJwtToken(String email,String name,Long id){


        byte[] key = Decoders.BASE64.decode((TOKEN_SECRET));
        SecretKey secretKey = Keys.hmacShaKeyFor(key);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")//標頭
                .setHeaderParam("alg","HS256")
                .setSubject(name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .claim("email",email)
                .claim("name",name)
                .claim("id",id)
                .signWith(secretKey,SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims verify(String token){
        try {
            Jws<Claims> claimsJws = Jwts
                    .parserBuilder()
                    .setSigningKey(TOKEN_SECRET)
                    .build()
                    .parseClaimsJws(token);

            return claimsJws.getBody();

        }catch (JwtException jwtException){
            jwtException.printStackTrace();
            //這裡會判斷jwt是否過期，如果過期拋出異常
            //1.refresh token
            //2.return 頁面 String
            
            
            return null;
        }


    }
    public static String getMemberName(String token){
        return Objects.requireNonNull(verify(token)).getSubject();
    }




}
