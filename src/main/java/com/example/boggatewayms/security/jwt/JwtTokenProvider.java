package com.example.boggatewayms.security.jwt;

import com.example.boggatewayms.exception.UnauthorisedException;
import com.example.boggatewayms.security.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Component
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService userDetailsService;

    private String secretKey;

    public JwtTokenProvider(JwtProperties jwtProperties, CustomUserDetailsService userDetailsService) {
        this.jwtProperties = jwtProperties;
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(jwtProperties.getSecretKey().getBytes());
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");

        return (!Objects.isNull(bearerToken) && bearerToken.startsWith("Bearer")) ?
                bearerToken.substring(7) : null;
    }

    public boolean validateToken(String token) {

        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);

            return (!claims.getBody().getExpiration().before(new Date()));
        } catch (JwtException | IllegalArgumentException e) {
            throw new UnauthorisedException("Invalid Token");
        }
    }
}
