package com.boeing.ps.innovationvenue.config;

import com.boeing.ps.innovationvenue.service.impl.UserProfileServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtConfigUtil implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(JwtConfigUtil.class);
    public static final long JWT_TOKEN_VALIDITY = 1 * 60 * 60; /* 1hr or 60min*/
    public static final String SIGNING_KEY = "2BE298D85E70605A6EFFC09C5B76C20838A08FECEA9D85C1E502D67D12D4688F"; /*hardcoded for now. it can also be picked from application properties*/

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("bemsId", userDetails.getUsername().split("~")[0]);
        claims.put("isPSEmp", userDetails.getUsername().split("~")[1]);
        claims.put("emailId", userDetails.getPassword().split("~")[0]);
        logger.info("sme flag is: "+userDetails.getPassword().split("~")[1].indexOf("#"));
        if(userDetails.getPassword().split("~")[1].indexOf("#") > 0) {
            claims.put("isAdmin", userDetails.getPassword().split("~")[1].split("#")[0]);
            claims.put("isSME", userDetails.getPassword().split("~")[1].split("#")[1]);
        }
        else{
            claims.put("isAdmin", "false");
            claims.put("isSME", "false");
        }

        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, getSecretKey()).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String getSecretKey() {
        return Base64.getEncoder().encodeToString(SIGNING_KEY.getBytes());
    }
}
