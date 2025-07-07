package com.example.puntos_verdes.Service;
import com.example.puntos_verdes.Entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private static final String SECRET = "holaestaesmisecretoultrasecretosdfsdfsdfsdfsdfslkdjflksdjfklj4k4jkl5jlk4j5lkjkjg";

    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    private  String getToken(Map<String,Object> extraClaims, UserDetails usuario) {
        Long userId = ((Usuario) usuario).getId();
        extraClaims.put("id", userId);
        extraClaims.put("role", usuario.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .findFirst()
                .orElse("USER"));

        return Jwts //un  tipo de objeto
                .builder()
                .setClaims(extraClaims)
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getCorreoFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        final String correo = getCorreoFromToken(token);
        return (correo.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());

    }
    private Claims getAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Date getExpirationDateFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Long getUserIdFromToken(String token) {
        String jwtToken = token.replace("Bearer ", "");
        Claims claims = getAllClaims(jwtToken);

        Object idObject = claims.get("id");
        if (idObject == null) {
            throw new IllegalArgumentException("El token no contiene un ID válido");
        }

        try {
            return Long.parseLong(idObject.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El ID en el token no es un número válido");
        }
    }


}
