package br.edu.iftm.gateway_matematica.service;

public interface ServicoJwt {
    String extrairNomeUsuario(String token);
    String extrairUsuarioId(String token);
    String extrairTipoUsuario(String token);
    boolean tokenValido(String token);
}