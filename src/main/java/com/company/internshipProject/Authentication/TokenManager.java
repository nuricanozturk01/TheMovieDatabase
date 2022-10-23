package com.company.internshipProject.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class TokenManager {

    private static final int validity = 10 * 60 * 1000;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }

    public boolean tokenValidate(String token)
    {
        return getUsernameToken(token) != null && isExpired(token);
    }


    public String getUsernameToken(String token)
    {
        var claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpired(String token) {
        var claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }


    private Claims getClaims(String token)
    {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}