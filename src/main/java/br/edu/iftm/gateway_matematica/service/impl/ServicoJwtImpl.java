package br.edu.iftm.gateway_matematica.service.impl;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.iftm.gateway_matematica.service.ServicoJwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class ServicoJwtImpl implements ServicoJwt {

    @Value("${CHAVE_ASSINATURA_JWT}")
    private String chaveSecreta;

    @Override
    public String extrairNomeUsuario(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    @Override
    public String extrairUsuarioId(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("usuarioId", String.class);
    }

    @Override
    public String extrairTipoUsuario(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("tipoUsuario", String.class);
    }

    @Override
    public boolean tokenValido(String token) {
        try {
            Date expiration = Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration();
            return expiration.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(chaveSecreta));
    }
}
