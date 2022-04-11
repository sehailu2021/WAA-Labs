package com.example.lab5.util;

import io.jsonwebtoken.*;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String secret = "top-secret";
    private final long expiration= 5 * 60 * 60 * 60;
    private final long refreshExpiration= 5 * 60 * 60 * 60 * 60;

    public <T> T  getClaimsFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token){
        return  Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

    }
    public Date getIssuedAtDateFormToken(String token){
        return getClaimsFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFormToken(String token){
        return getClaimsFromToken(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFormToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateRefreshToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getSubject(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println(e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public String getUsernameFromToken(String token) {
        String result = null;
        try {
            result = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
//
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//
//        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
//
//        if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
//            claims.put("isAdmin", true);
//        }
//        if (roles.contains(new SimpleGrantedAuthority("ROLE_USERb"))) {
//            claims.put("isUser", true);
//        }
//
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//
//    }
//
//    public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {
//
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//
//    }
//public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
//    Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//
//    List<SimpleGrantedAuthority> roles = null;
//
//    Boolean isAdmin = claims.get("isAdmin", Boolean.class);
//    Boolean isUser = claims.get("isUser", Boolean.class);
//
//    if (isAdmin != null && isAdmin) {
//        roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }
//
//    if (isUser != null && isAdmin) {
//        roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//    return roles;
//
//}

}
