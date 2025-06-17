// package br.edu.iftm.gateway_matematica.service;

// import java.util.Collections;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import br.edu.iftm.gateway_matematica.config.DetalhesUsuarioPersonalizado;

// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {

//     @Autowired
//     private ServicoJwt servicoJwt;

//     // Espera receber o token JWT como "username"
//     @Override
//     public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
//         String usuarioId = servicoJwt.extrairUsuarioId(token);
//         String tipoUsuario = servicoJwt.extrairTipoUsuario(token);

//         return new DetalhesUsuarioPersonalizado(
//                 usuarioId, // nomeUsuario
//                 null,      // senha
//                 usuarioId, // usuarioId
//                 tipoUsuario, // tipoUsuario extraído do JWT
//                 Collections.emptyList() // authorities
//         );
//     }
// }