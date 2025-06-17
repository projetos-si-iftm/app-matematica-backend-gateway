package br.edu.iftm.gateway_matematica.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import br.edu.iftm.gateway_matematica.service.ServicoJwt;
import reactor.core.publisher.Mono;

@Component
public class FiltroAutenticacaoJWT implements GlobalFilter, Ordered {
private static final Logger log = LoggerFactory.getLogger(FiltroAutenticacaoJWT.class);
    @Autowired
    private ServicoJwt servicoJwt;

    private static final List<String> ROTAS_PERMITIDAS = List.of(
        "/usuario/api/v1/estudante/autenticacao",
            // "/usuario/api/v1/estudante/concluir-cadastro",
        "/usuario/api/v1/professor/autenticacao"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        log.info("Gateway path: {}", path);
        // Permitir rotas públicas sem autenticação
        if (ROTAS_PERMITIDAS.stream().anyMatch(path::contains)) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        // Valida o token JWT
        if (!servicoJwt.tokenValido(token)) { 
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // (Opcional) Adiciona informações do usuário nos headers para downstream
        ServerHttpRequest mutatedRequest = exchange.getRequest().mutate()
                .header("usuarioId", servicoJwt.extrairUsuarioId(token))
                .header("tipoUsuario", servicoJwt.extrairTipoUsuario(token))
                .build();

        return chain.filter(exchange.mutate().request(mutatedRequest).build());
    }

    @Override
    public int getOrder() {
        return -1; // Executa antes dos filtros padrão
    }
}